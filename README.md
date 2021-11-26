


<p align="center"><img src="https://user-images.githubusercontent.com/58849278/143367151-048312bf-6183-4e38-9d50-278d9018caec.png" width = 100%/></p>
<h3 align="center">
친구에게 듣는 생생한 '진짜 맛집' 정보 ,
대학생들의 식문화 교류의 장  </h3>
<p align="center">
단계적 일상 회복을 목표로 한 위드 코로나가 시행됨에 따라 비대면 수업을 하던 대학생들은 대면 수업의 재개로 학교 인근에서 식사해야 하는 경우들이 늘어났습니다. 코로나 학번이라고 불리는 제대로 된 대학 생활을 해보지 못한 학생들을 위해 식당 정보를 제공하고 나아가 대학 식문화 교류의 장을 마련하여 대학가 상권 회복과 활성화에 기여하는 서비스를 제공합니다. </p>
<h1 align="left">withmeal core function</h1>
<h3 align="left">1. Home</h3>
<h5 align="left">
💡 메인 홈 화면을 통해 소속 학교 사람들의 리뷰인 피드와 리뷰 순위의 맛집 리스트, 새로 생긴 학교 인근 식당의 정보를 확인할 수 있습니다. 사용자의 팔로잉이 새로운 리뷰를 업데이트하면 메인 홈 화면 상단에 활성화 버튼이 나타나며 실시간으로 팔로잉이 남긴 리뷰를 확인할 수 있습니다. </h5>
<h5 align="left">
☑️ 메인 화면은 Toolbar, Recyclerview, 3개의 TabItem(Feed, Hot, New)으로 구성된 Tablayout, 각각의 Fragment를 담는 ViewPager로 설계하였습니다.CoordinatorLayout의 자식뷰에 Behaviors를 지정하는 방식을 활용하여 인터렉션을 구현하여 사용자의 편의성을 고려하였습니다. 위드밀만의 특징을 살려낸 키워드 추출 서비스는 다중 선택이 가능하기에 컨테이너 내의 아이템 요소를 컨테이너 크기에 따라 자동으로 배열해주는 레이아웃 모델 FlexboxLayout 라이브러리를 사용하였습니다. </h5>
<p align="center"><img src="https://user-images.githubusercontent.com/58849278/143581531-9ee82243-afb5-4ce4-b208-3d4268ef3523.png" width = 100%/></p>
<h3 align="center">
<h3 align="left">2. Map</h3>
<h5 align="left">
💡 팔로잉하는 지인들의 맛집 기록과 내가 기록한 식당의 정보 및 위치를  지도와 위치 아이콘을 통해 한눈에 확인할 수 있는 페이지입니다. 마커 선택 시 해당 음식점의 카드가 보여지고, 식당 상세 정보 페이지로 연결됩니다. </h5>
<h5 align="left">
☑️ 위드밀 맵은 Naver Map API를 사용하였으며, 검색 기능은 Naver 검색 API를 활용하여 키워드 검색이 가능하게 하였습니다. 맵에는 2가지 위드밀 커스텀 마커를 표시하여 사용자가 직관적으로 볼 수 있습니다.</h5>
<p align="center"><img src="https://user-images.githubusercontent.com/58849278/143581844-cecd6b78-4f6a-4a28-9267-6ad481da1722.png" width = 100%/></p>
<h3 align="center">
<h3 align="left">3. My page</h1>
<h5 align="left">
💡 팔로잉 팔로워, 작성한 식당 기록, 북마크한 음식점을 확인하고 관리할 수 있는 페이지입니다. 환경설정 아이콘을 통해 프로필 사진 및 닉네임을 수정하거나 학교 설정 관리, 언어 및 알림 설정 등 기타 시스템을 관리할 수 있습니다. </h5>
<h5 align="left">
☑️ 내 정보 페이지에서도 메인 뷰와 마찬가지로 무한 스크롤과 인터렉션이 가능하며 가봤어요 탭을 누르면 Gridlayout으로 구성된 식당 정보가 보여지고 가고 싶어요 탭을 누르면 사용자가 북마크한 식당 리스트를 보여줍니다. 식당 아이템을 클릭하면 식당의 상세 정보를 확인할 수 있으며 이는 Naver Clova Summary API를 활용합니다.</h5>
<p align="center"><img src="https://user-images.githubusercontent.com/58849278/143582029-ca943259-eb54-4ce2-9cff-0261e17f37ef.png" width = 100%/></p>
<h3 align="center">

<h1 align="left">withmeal architecture</h1>
<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.5.30-yellowgreen?logo=kotlin"/>
  <img src="https://img.shields.io/badge/Arctic Fox | -2020.3.1-blue?logo=Android+Studio"/>
  <img src="https://img.shields.io/badge/targetSdk-31-green?logo=Android"/>
  <img src="https://img.shields.io/badge/minSdk-29-green?logo=Android"/>
</p>
<p align="center"><img src="https://user-images.githubusercontent.com/58849278/143586656-58855204-a190-46dd-9a03-5185b8ed2918.png" width = 100%/></p>
<h5 align="left">
1. Single Activity와 Multiple Fragments로 구성을 하여 이 구조에 최적화된 Android Jetpack Library중 Navigation을 사용하여 화면 전환을 합니다. NavArgs로 Type이 지정된 데이터 전달이 가능한 점을 활용하였습니다.</h5>
<h5 align="left">
2. MVVM 아키텍쳐를 기본으로 하고 데이터 개체 매핑 라이브러리 Room, Rxjava, Flowable, Livedata Observable,  Coroutine 등을 활용하여 상용구 코드의 작성 및 메모리 누수와 비정상 종료를 줄여주는 Android 권장 사항을 준수합니다. </h5>
<h5 align="left">
3. 액티비티나 프래그먼트와 같은 구성요소의 수명 주기 상태 관련 정보를 포함하며 다른 객체가 이 상태를 관찰할 수 있게 하는 Lifecycle을 활용하여 수명 주기 상태를 추적합니다. Android 프레임워크에 정의된 대부분의 앱 구성요소에는 수명 주기가 연결되어 있기 때문에 수명 주기를 고려해야 하며, 메모리 누수 또는 비정상 종료를 방지합니다.</h5>

<h1 align="left">withmeal system flow</h1>
<p align="center"><img src="https://user-images.githubusercontent.com/58849278/143587752-7261c386-dd2c-4943-95c5-201ee9737994.png" width = 100%/></p>

<h1 align="left">withmeal opensource library</h1>
<p align="center"><img src="https://user-images.githubusercontent.com/58849278/143590047-7a5b89d6-00cb-49a2-b362-e2e57fc2d616.png" width = 70%/></p>
<h4 align="left">
외부 라이브러리</h4>
<h5 align="left">
✔️Naver Map API :  위드밀 지도맵에서 활용</h5>
<h5 align="left">
✔️Naver Clova Summary API : 장소 정보에 대한 요약 정보 추출</h5>
<h5 align="left">
✔️Naver Search API : 키워드(식당명) 검색 결과에 활용</h5>
<h5 align="left">
✔️Google Firebase : 사용자에게 알림을 주는 FCM Cloud
 Messaging 서비스</h5>


<h1 align="left"> contributor</h1>

<table>
  <tr>
    <td align="center"><a href="https://github.com/jooyae"><img src="https://github.com/jooyae.png?v=4?s=100" width="100px;" alt=""/><br /><sub><b>박주예</b></sub></a><br /></td>
  </tr>
</table>
<br>

 <h1 align="left"> backend repository</h1>

👩🏻‍💻  [Server](https://github.com/NyumNyumGood/WithMeal_Server)








