package com.example.examplemvvm

import android.app.Activity
import androidx.annotation.IdRes
import androidx.appcompat.widget.Toolbar

fun Activity.getToolbarNavigationContentDescription(@IdRes toolbarId: Int) =
        findViewById<Toolbar>(toolbarId).navigationContentDescription as String