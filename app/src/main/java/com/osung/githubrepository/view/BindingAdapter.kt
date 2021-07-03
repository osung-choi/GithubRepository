package com.osung.githubrepository.view

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("app:onEditorSearchActionListener")
    fun setOnEditorSearchActionListener(editText: EditText, listener: () -> Unit) {
        editText.setOnEditorActionListener { _, actionId, _ ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                listener.invoke()
                true

            }else false
        }
    }
}