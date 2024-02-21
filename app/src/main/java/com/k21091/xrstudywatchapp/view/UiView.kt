package com.k21091.xrstudywatchapp.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class UiView {
    private val parts = UiParts(this)
    val uploadButtonChecked = mutableStateOf(false)

    val nearObjectButtonChecked = mutableStateOf(false)

    fun onUploadButtonClicked() {
        // もしオブジェクト近くのボタンが true なら、false に設定する
        if (nearObjectButtonChecked.value) {
            nearObjectButtonChecked.value = false
        }
        uploadButtonChecked.value = !uploadButtonChecked.value
        Log.d("up", uploadButtonChecked.value.toString())
    }

    fun onNearObjectButtonClicked() {
        // もしアップロードボタンが true なら、false に設定する
        if (uploadButtonChecked.value) {
            uploadButtonChecked.value = false
        }
        nearObjectButtonChecked.value = !nearObjectButtonChecked.value
        Log.d("near", nearObjectButtonChecked.value.toString())
    }
    @Composable
    fun Buttonlayout() {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.Transparent)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .background(color = Color.Transparent)
            ) {
                parts.UploadMenuButton()
                parts.NearObjectMenuButton()
            }
        }
    }
    @Composable
    fun Menulayout(){
        if (uploadButtonChecked.value){
            parts.UploadMenu()
        }
        if (nearObjectButtonChecked.value){
            //parts.NearObjectMenu()
        }
    }
}