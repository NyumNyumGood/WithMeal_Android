package org.android.wantedhackathon.review.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentWriteReviewBinding
import org.android.wantedhackathon.home.data.TagEntity
import org.android.wantedhackathon.home.ui.adapter.TagAdapter
import org.android.wantedhackathon.review.viewmodel.ReviewViewModel
import org.android.wantedhackathon.review.entity.TagInfoEntity
import org.android.wantedhackathon.review.UploadPicturesViewPagerAdapter
import org.android.wantedhackathon.util.AutoClearedValue
import java.lang.RuntimeException

@AndroidEntryPoint
class WriteReviewFragment: Fragment() {
    private var binding by AutoClearedValue<FragmentWriteReviewBinding>()
    private val viewModel: ReviewViewModel by viewModels()
    private val args: WriteReviewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentWriteReviewBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        getPictures()
        loadPictures()
        changeCurrentImageShowed()
        popBackStack()
        initWriteReviewViewPager()
        changeWriteReviewProgress()
        setSelectedTagList()
        writeNextStep()
        completeReview()
    }

    private fun getPictures() {
        viewModel.changeUploadPictures(
            args.pictures.map { it.toUri() }
        )
    }

    private fun loadPictures() {
        binding.viewpagerUploadImages.run {
            currentItem = 0
            adapter = UploadPicturesViewPagerAdapter()
            viewModel.uploadPictures.observe(viewLifecycleOwner) {
                (adapter as UploadPicturesViewPagerAdapter).submitList(it)
            }
        }
    }

    private fun initWriteReviewViewPager() {
        binding.viewpagerStoreInfo.run {
            isUserInputEnabled = false
            offscreenPageLimit = 1
            adapter = StoreInfoViewPagerAdapter(this@WriteReviewFragment)
        }
        binding.textviewNextButton.text = "다음"
    }

    private fun changeCurrentImageShowed() {
        binding.viewpagerUploadImages.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageSelected(position: Int) {
                viewModel.changeCurrentImageIdx(position)
            }
        })
    }

    private fun changeWriteReviewProgress() {
        binding.viewpagerStoreInfo.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageSelected(position: Int) {
                viewModel.changeWriteReviewProgress(position)
            }
        })
        binding.textviewNextButton.run {
            viewModel.writeReviewProgress.observe(viewLifecycleOwner) { progress ->
                text = when(progress) {
                    0 -> "다음"
                    1 -> "작성 완료"
                    else -> throw RuntimeException("error to find progress write review")
                }
            }
        }
    }

    private fun completeReview(){
        if(viewModel.writeReviewProgress.value == 1) {
            binding.textviewNextButton.setOnClickListener {
                findNavController().navigate(R.id.action_writeReviewFragment_to_myPageFragment)
            }
        }
    }

    private fun setSelectedTagList() {
        binding.recyclerviewStoreTag.run {
            adapter = TagAdapter()
            viewModel.selectedTagList.observe(viewLifecycleOwner) {
                (adapter as TagAdapter).apply {
                    tagList = it.map { TagEntity(it.image, it.tag) }
                    notifyDataSetChanged()
                }
                binding.textviewNextButton.run {
                    background = if(!it.isNullOrEmpty()) {
                        isClickable = true
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                        ContextCompat.getDrawable(requireContext(), R.drawable.button_signup_active)
                    } else {
                        isClickable = false
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.grey4))
                        ContextCompat.getDrawable(requireContext(), R.drawable.button_signup_unactive)
                    }
                }
            }
        }
    }

    fun changeSelectedTag(selectedTags: List<TagInfoEntity>) {
        viewModel.changeSelectedTagList(selectedTags)
    }

    private fun writeNextStep() {
        binding.textviewNextButton.setOnClickListener {
            binding.viewpagerStoreInfo.currentItem = 1
        }
    }

    private fun popBackStack() {
        binding.imageviewBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}