package com.example.insta.ktorcompose.ui.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.insta.ktorcompose.R
import com.example.insta.ktorcompose.domain.entitiy.QouteEntity
import com.example.insta.ktorcompose.domain.model.Quote
import com.example.insta.ktorcompose.ui.components.CustomImageView
import com.example.insta.ktorcompose.ui.components.CustomTextView
import com.example.insta.ktorcompose.ui.ui.ui.theme.KtorComposeTheme
import com.example.insta.ktorcompose.ui.viewmodels.MainViewModel
import com.example.insta.ktorcompose.ui.viewmodels.RoomViewModel
import com.example.insta.ktorcompose.util.newScreen
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class RoomActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorComposeTheme {
                val viewModel: RoomViewModel = getViewModel()
                val list=viewModel.observeQuote.collectAsState()
                QuotesListScreen(list.value)
            }
        }
    }
}

@Composable
fun QuotesListScreen(list: List<QouteEntity>) {
    val context= LocalContext.current
    val isDoneButtonVisible= remember {
        mutableStateOf(false)
    }
    val selectedQoute= remember {
        mutableStateOf("")
    }
    ConstraintLayout(modifier =Modifier.fillMaxSize()) {
        val (btn,donebtn,rec)=createRefs()
        CustomTextView(textString = "Navigate to HomeScreen", textSize =20.sp, textColor = R.color.black,
            modifier = Modifier
                .constrainAs(btn) {
                    top.linkTo(parent.top, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                }
                .clickable {
                    context.newScreen(MainActivity::class.java)
                })
        if (isDoneButtonVisible.value){
            CustomImageView(imageResource = R.drawable.icons8_done_64,
                modifier = Modifier
                    .constrainAs(donebtn) {
                        top.linkTo(parent.top, 10.dp)
                        end.linkTo(parent.end, 10.dp)
                    }
                    .size(30.dp)
            )
        }
        LazyColumn(
            modifier =Modifier
                .constrainAs(rec) {
                    top.linkTo(btn.bottom,20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    width= Dimension.fillToConstraints
                    height= Dimension.fillToConstraints
                },verticalArrangement = Arrangement.SpaceBetween,
        ) {
            items(list.size) { quote ->
                QuoteItem(item = list[quote],selectedQoute){
                    isDoneButtonVisible.value=true
                }
            }
        }
    }
}

@Composable
private fun QuoteItem(item: QouteEntity, selectedQoute: MutableState<String>, onLong: () -> Unit, ) {
    Column(
        modifier = Modifier.height(60.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        selectedQoute.value = item.content
                        onLong()
                    }
                )
            }
            .background(if (selectedQoute.value == item.content) Color.Gray else Color.Transparent) // Change background color on long press
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Text(text = item.content)
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Black.copy(0.50f))
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    KtorComposeTheme {

    }
}