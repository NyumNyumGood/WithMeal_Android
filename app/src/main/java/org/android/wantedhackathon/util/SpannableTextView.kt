package org.android.wantedhackathon.util

import android.content.Context
import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import org.android.wantedhackathon.R

class SpannableTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(
    context, attrs, defStyle
) {
    private val typeFace = Typeface.create(ResourcesCompat.getFont(context, R.font.pretendardbold), Typeface.NORMAL)
    private var spannableStart = -1
    private var spannableEnd = -1
    init {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SpannableText,
            0,
            0
        )
        val spannableString = SpannableString(text)

        if(typedArray.hasValue(R.styleable.SpannableText_span_start) && typedArray.hasValue(R.styleable.SpannableText_span_end)) {
            spannableStart = typedArray.getInt(R.styleable.SpannableText_span_start, 0)
            spannableEnd = typedArray.getInt(R.styleable.SpannableText_span_end, 0) + 1

            spannableString.setSpan(CustomTypefaceSpan(typeFace), spannableStart, spannableEnd, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            text = spannableString
        }
    }

}