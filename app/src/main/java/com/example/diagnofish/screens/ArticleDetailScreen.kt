package com.example.diagnofish.screens

import BasicText
import ScreenTitle
import SectionTitle
import StatusResult
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDirections
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diagnofish.R
import com.example.diagnofish.model.ArticleItem
import com.example.diagnofish.model.HistoryItem
import com.example.diagnofish.model.dummyArticleItems
import com.example.diagnofish.model.dummyHistoryItems
import com.example.diagnofish.ui.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ArticleDetailScreen(
    articleItem: ArticleItem = dummyArticleItems[0],
    navController: NavHostController = rememberNavController()
) {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                 IconButton(onClick = {
                     navController.popBackStack()
                 }) {
                     Image(painter = painterResource(id = R.drawable.icon_back), contentDescription = "Back")
                 }
            },
            title = { ScreenTitle(stringResource(id = R.string.articles)) }
        )
    }) {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Image(painter = painterResource(id = articleItem.image), contentDescription = articleItem.title, modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop
            )
            SectionTitle(text = articleItem.title)
            BasicText(text = articleItem.content, textAlign = TextAlign.Justify)
        }
    }
}