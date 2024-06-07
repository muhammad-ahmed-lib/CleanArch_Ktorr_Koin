package com.example.insta.ktorcompose.ui.components

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomTextView(
    text:Int=0,
    textString:String="",
    fontFamily:Int=0,
    textSize:TextUnit,
    textColor:Int,
    @SuppressLint("ModifierParameter") modifier: Modifier=Modifier,
    isOpacityEnabled:Boolean=false,
    opacity:Float=0f
){
    Text(text =if (text!=0) stringResource(id = text) else textString ,
        style = TextStyle(
            fontSize = textSize,
            fontFamily =if (fontFamily!=0)  FontFamily(Font(fontFamily)) else null,
            color = if (!isOpacityEnabled) colorResource(id = textColor) else colorResource(id = textColor).copy(opacity)
        ),
        modifier=modifier
    )
}