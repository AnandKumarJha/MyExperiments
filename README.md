# MyExperiments

## Options on header of Actionbar
<p align="center">
  <img src="/Screenshot_1576861610.png" width="250" title="hover text">
  <img src="/Screenshot_1576861617.png" width="250" title="hover text">
</p>
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/MainActivity.kt

## Extension Function
Use this showToastMsg(msgToDisplay) in activity/fragment 
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/util/CommonUtil.kt

## Base Activity
This type of things are done when we have to use same thing on almost all the activities like same bottom navigation, action bar might be required so rather than doing it again and again we can use base activity concept to prevent boilerplate code and for some common functions it could be used as well.
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/BaseActivity.kt
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/ChildActivity.kt
<p align="center"> <img src="/Screenshot_1576866594.png" width="250" title="hover text"> </p>
Here in the above image we can observe that the green layouts are parent layout part and the red is child one. In parent we need to provide the child continer in which the child layout is inflated.

## SetRetainState
This is used for retaining the state of a fragment while the activity is rotated. On rotation, the activity is destroyed and at the same time if asynctask is running then it would still run in background would not be able to update the UI because it would not have the latest activity reference. But on setting setRetainState(true) fragment is not destroyed and after recreation of activity the fresh instance of activity is given to the asyncTask contained by fragment. That's how asyncTask or other long running task work in fragment with setRetainState.
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/fragment_testing/headless/HeadlessActivity.kt<Br />
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/fragment_testing/headless/HeadlessFragment1.kt
