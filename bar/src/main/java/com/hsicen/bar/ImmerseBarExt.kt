package com.hsicen.bar

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment


// 初始化ImmersionBar
@JvmOverloads
inline fun Activity.immersionBar(isOnly: Boolean = false, block: ImmerseBar.() -> Unit) =
  ImmerseBar.with(this, isOnly).apply {
    this ?: return@apply
    block(this)
  }?.init()

@JvmOverloads
inline fun Fragment.immersionBar(isOnly: Boolean = false, block: ImmerseBar.() -> Unit) =
  ImmerseBar.with(this, isOnly).apply {
    this ?: return@apply
    block(this)
  }?.init()

@JvmOverloads
inline fun android.app.Fragment.immersionBar(
  isOnly: Boolean = false,
  block: ImmerseBar.() -> Unit
) = ImmerseBar.with(this, isOnly).apply {
  this ?: return@apply
  block(this)
}?.init()

@JvmOverloads
inline fun DialogFragment.immersionBar(isOnly: Boolean = false, block: ImmerseBar.() -> Unit) =
  ImmerseBar.with(this, isOnly).apply {
    this ?: return@apply
    block(this)
  }?.init()

@JvmOverloads
inline fun android.app.DialogFragment.immersionBar(
  isOnly: Boolean = false,
  block: ImmerseBar.() -> Unit
) = ImmerseBar.with(this, isOnly).apply {
  this ?: return@apply
  block(this)
}?.init()

@JvmOverloads
inline fun Dialog.immersionBar(
  activity: Activity,
  isOnly: Boolean = false,
  block: ImmerseBar.() -> Unit
) = ImmerseBar.with(activity, this, isOnly).apply {
  this ?: return@apply
  block(this)
}?.init()

@JvmOverloads
inline fun Activity.immersionBar(
  dialog: Dialog,
  isOnly: Boolean = false,
  block: ImmerseBar.() -> Unit
) = ImmerseBar.with(this, dialog, isOnly).apply {
  this ?: return@apply
  block(this)
}?.init()

@JvmOverloads
inline fun Fragment.immersionBar(
  dialog: Dialog,
  isOnly: Boolean = false,
  block: ImmerseBar.() -> Unit
) = activity?.run {
  ImmerseBar.with(this, dialog, isOnly).apply {
    this ?: return@apply
    block(this)
  }?.init()
} ?: Unit

@JvmOverloads
inline fun android.app.Fragment.immersionBar(
  dialog: Dialog,
  isOnly: Boolean = false,
  block: ImmerseBar.() -> Unit
) = activity?.run {
  ImmerseBar.with(this, dialog, isOnly).apply {
    this ?: return@apply
    block(this)
  }?.init()
} ?: Unit

@JvmOverloads
fun Activity.immersionBar(isOnly: Boolean = false) = immersionBar(isOnly) { }

@JvmOverloads
fun Fragment.immersionBar(isOnly: Boolean = false) = immersionBar(isOnly) { }

@JvmOverloads
fun android.app.Fragment.immersionBar(isOnly: Boolean = false) = immersionBar(isOnly) { }

@JvmOverloads
fun DialogFragment.immersionBar(isOnly: Boolean = false) = immersionBar(isOnly) { }

@JvmOverloads
fun android.app.DialogFragment.immersionBar(isOnly: Boolean = false) = immersionBar(isOnly) { }

@JvmOverloads
fun Dialog.immersionBar(activity: Activity, isOnly: Boolean = false) =
  immersionBar(activity, isOnly) {}

@JvmOverloads
fun Activity.immersionBar(dialog: Dialog, isOnly: Boolean = false) = immersionBar(dialog, isOnly) {}

@JvmOverloads
fun Fragment.immersionBar(dialog: Dialog, isOnly: Boolean = false) = immersionBar(dialog, isOnly) {}

@JvmOverloads
fun android.app.Fragment.immersionBar(dialog: Dialog, isOnly: Boolean = false) =
  immersionBar(dialog, isOnly) {}

// dialog销毁
@JvmOverloads
fun Activity.destroyImmersionBar(dialog: Dialog, isOnly: Boolean = false) =
  ImmerseBar.destroy(this, dialog, isOnly)

@JvmOverloads
fun Fragment.destroyImmersionBar(dialog: Dialog, isOnly: Boolean = false) =
  activity?.run { ImmerseBar.destroy(this, dialog, isOnly) } ?: Unit

@JvmOverloads
fun android.app.Fragment.destroyImmersionBar(dialog: Dialog, isOnly: Boolean = false) =
  activity?.run { ImmerseBar.destroy(this, dialog, isOnly) } ?: Unit

// 状态栏扩展
val Activity.statusBarHeight get() = ImmerseBar.getStatusBarHeight(this)
val Fragment.statusBarHeight get() = ImmerseBar.getStatusBarHeight(this)
val android.app.Fragment.statusBarHeight get() = ImmerseBar.getStatusBarHeight(this)
val Context.statusBarHeight get() = ImmerseBar.getStatusBarHeight(this)

// 导航栏扩展
val Activity.navigationBarHeight get() = ImmerseBar.getNavigationBarHeight(this)
val Fragment.navigationBarHeight get() = ImmerseBar.getNavigationBarHeight(this)
val android.app.Fragment.navigationBarHeight get() = ImmerseBar.getNavigationBarHeight(this)
val Context.navigationBarHeight get() = ImmerseBar.getNavigationBarHeight(this)

val Activity.navigationBarWidth get() = ImmerseBar.getNavigationBarWidth(this)
val Fragment.navigationBarWidth get() = ImmerseBar.getNavigationBarWidth(this)
val android.app.Fragment.navigationBarWidth get() = ImmerseBar.getNavigationBarWidth(this)
val Context.navigationBarWidth get() = ImmerseBar.getNavigationBarWidth(this)

// ActionBar扩展
val Activity.actionBarHeight get() = ImmerseBar.getActionBarHeight(this)
val Fragment.actionBarHeight get() = ImmerseBar.getActionBarHeight(this)
val android.app.Fragment.actionBarHeight get() = ImmerseBar.getActionBarHeight(this)

// 是否有导航栏
val Activity.hasNavigationBar get() = ImmerseBar.hasNavigationBar(this)
val Fragment.hasNavigationBar get() = ImmerseBar.hasNavigationBar(this)
val android.app.Fragment.hasNavigationBar get() = ImmerseBar.hasNavigationBar(this)
val Context.hasNavigationBar get() = ImmerseBar.hasNavigationBar(this)

// 是否有刘海屏
val Activity.hasNotchScreen get() = ImmerseBar.hasNotchScreen(this)
val Fragment.hasNotchScreen get() = ImmerseBar.hasNotchScreen(this)
val android.app.Fragment.hasNotchScreen get() = ImmerseBar.hasNotchScreen(this)
val View.hasNotchScreen get() = ImmerseBar.hasNotchScreen(this)

// 获得刘海屏高度
val Activity.notchHeight get() = ImmerseBar.getNotchHeight(this)
val Fragment.notchHeight get() = ImmerseBar.getNotchHeight(this)
val android.app.Fragment.notchHeight get() = ImmerseBar.getNotchHeight(this)

// 是否支持状态栏字体变色
val isSupportStatusBarDarkFont get() = ImmerseBar.isSupportStatusBarDarkFont()

// 是否支持导航栏图标
val isSupportNavigationIconDark get() = ImmerseBar.isSupportNavigationIconDark()

// 检查view是否使用了fitsSystemWindows
val View.checkFitsSystemWindows get() = ImmerseBar.checkFitsSystemWindows(this)

// 导航栏是否在底部
val Activity.isNavigationAtBottom get() = ImmerseBar.isNavigationAtBottom(this)
val Fragment.isNavigationAtBottom get() = ImmerseBar.isNavigationAtBottom(this)
val android.app.Fragment.isNavigationAtBottom get() = ImmerseBar.isNavigationAtBottom(this)

// 是否是全面屏手势
val Context.isGesture get() = ImmerseBar.isGesture(this)
val Fragment.isGesture get() = ImmerseBar.isGesture(this)
val android.app.Fragment.isGesture get() = ImmerseBar.isGesture(this)

// statusBarView扩展
fun Activity.fitsStatusBarView(view: View) = ImmerseBar.setStatusBarView(this, listOf(view))
fun Fragment.fitsStatusBarView(view: View) = ImmerseBar.setStatusBarView(this, listOf(view))
fun android.app.Fragment.fitsStatusBarView(view: View) = ImmerseBar.setStatusBarView(this, listOf(view))

// titleBar扩展
fun Activity.fitsTitleBar(view: List<View>) = ImmerseBar.setTitleBar(this, view)
fun Fragment.fitsTitleBar(view: List<View>) = ImmerseBar.setTitleBar(this, view)
fun android.app.Fragment.fitsTitleBar(view: List<View>) = ImmerseBar.setTitleBar(this, view)

fun Activity.fitsTitleBarMarginTop(view: List<View>) =
  ImmerseBar.setTitleBarMarginTop(this, view)

fun Fragment.fitsTitleBarMarginTop(view: List<View>) =
  ImmerseBar.setTitleBarMarginTop(this, view)

fun android.app.Fragment.fitsTitleBarMarginTop(view: List<View>) =
  ImmerseBar.setTitleBarMarginTop(this, view)

// 隐藏状态栏
fun Activity.hideStatusBar() = ImmerseBar.hideStatusBar(window)
fun Fragment.hideStatusBar() = activity?.run { ImmerseBar.hideStatusBar(window) } ?: Unit
fun android.app.Fragment.hideStatusBar() = activity?.run { ImmerseBar.hideStatusBar(window) }
  ?: Unit

// 显示状态栏
fun Activity.showStatusBar() = ImmerseBar.showStatusBar(window)
fun Fragment.showStatusBar() = activity?.run { ImmerseBar.showStatusBar(window) } ?: Unit
fun android.app.Fragment.showStatusBar() = activity?.run { ImmerseBar.showStatusBar(window) }
  ?: Unit

// 解决顶部与布局重叠问题，不可逆
fun Activity.setFitsSystemWindows() = ImmerseBar.setFitsSystemWindows(this)
fun Fragment.setFitsSystemWindows() = ImmerseBar.setFitsSystemWindows(this)
fun android.app.Fragment.setFitsSystemWindows() = ImmerseBar.setFitsSystemWindows(this)
