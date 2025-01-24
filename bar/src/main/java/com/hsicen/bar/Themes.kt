package com.hsicen.bar

import android.content.Context
import android.content.res.Configuration


/*** 当前主题判断*/
fun Context.isDarkTheme(): Boolean {
  val flag = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
  return flag == Configuration.UI_MODE_NIGHT_YES
}

/*** 主题处理*/
fun Configuration.themeModel(
  onLightModel: (() -> Unit)? = null,
  onDarkModel: (() -> Unit)? = null
) {
  when (uiMode and Configuration.UI_MODE_NIGHT_MASK) {
    Configuration.UI_MODE_NIGHT_NO -> {
      onLightModel?.invoke()
    } // Night mode is not active, we're using the light theme

    Configuration.UI_MODE_NIGHT_YES -> {
      onDarkModel?.invoke()
    } // Night mode is active, we're using dark theme
  }
}
