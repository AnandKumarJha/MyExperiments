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
This is used for retaining the state of a fragment while the activity is rotated. On rotation, the activity is destroyed and at the same time if asynctask is running then it would still run in background would not be able to update the UI because it would not have the latest activity reference. But on setting setRetainState(true) fragment is not destroyed and after recreation of activity the fresh instance of activity is given to the asyncTask contained by fragment. That's how asyncTask or other long running task work in fragment with setRetainState.<br />
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/fragment_testing/headless/HeadlessActivity.kt<Br />
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/fragment_testing/headless/HeadlessFragment1.kt

## Backstack management
As we know for code reusability we uses fragment. As per the human tendancy if there is any mistake or the next page is not liked by the user he instantly tries to go back like activity in many a case. To get backstack functionality we need to add <b>addToBackStack(BackStack.TAG)</b> with fragment manager. In many a case we would like to navigate some customised position of fragment backStack. For that we can use the following methods<br />

    popBackStack() pops the top fragment transaction from stack.
    popBackStack(String tag, int flag) pops till the transaction with mentioned ‘tag’ if flag is POP_BACK_STACK_INCLUSIVE, or else 0 can be used.
    popBackStack(int id, int flag) pops till the transaction with mentioned ‘tag’. Id is the identifier returned from FragmentTransaction.commit().
If any fragment is opened two times with same tag and popped with that tag than it would only popped the nearest tag. For example A->B->C->A->B->C. Here If I am popping backStack till a then the stack would be like this A->B->C->A rather than clearing the back stack.
Here the following method could also be used in place of the above methods

    popBackStackImmediate()
    popBackStackImmediate(String tag, int flag)
    popBackStackImmediate(int id, int flag)
    
https://github.com/AnandKumarJha/MyExperiments/blob/master/app/src/main/java/com/example/myexperiments/fragment_testing/backstack/BackStackActivity.kt

## Broadcast reciever
https://github.com/AnandKumarJha/MyExperiments/tree/master/app/src/main/java/com/example/myexperiments/broadcast_reciever

## Services
https://github.com/AnandKumarJha/MyExperiments/tree/master/app/src/main/java/com/example/myexperiments/service_testing

## Parcelable
https://github.com/AnandKumarJha/MyExperiments/tree/master/app/src/main/java/com/example/myexperiments/parcelable

