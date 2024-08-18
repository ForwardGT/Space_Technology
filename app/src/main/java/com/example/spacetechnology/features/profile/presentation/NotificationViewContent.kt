package com.example.spacetechnology.features.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.core.utils.view.CustomToast
import com.example.spacetechnology.notification.ChanelInformation
import com.example.spacetechnology.notification.subscribeTopicNews

@Composable
fun NotificationViewContent(
    viewModel: ViewModelProfile
) {

    val stateSubscribe by viewModel.stateSubscribe.collectAsState()

    var showToast by remember { mutableStateOf(false) }

    Scaffold { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .padding(10.dp)
        ) {
            FollowNotification(
                textNotification = "Follow News",
                topicName = ChanelInformation.ChanelNews.name,
                onClick = { viewModel.setStateSubscribeNews(news = !stateSubscribe.news) },
                stateSubscribe = stateSubscribe.news
            )

            CustomSpacer(v = 2.dp)

            FollowNotification(
                textNotification = "Follow Sales",
                topicName = ChanelInformation.ChanelSales.name,
                onClick = { viewModel.setStateSubscribeSales(sales = !stateSubscribe.sales) },
                stateSubscribe = stateSubscribe.sales
            )

            CustomToast(
                message = "Follow Success!",
                isVisible = showToast,
                onDismiss = { showToast = false }
            )
        }
    }
}


@Composable
private fun FollowNotification(
    textNotification: String,
    onClick: () -> Unit,
    topicName: String,
    stateSubscribe: Boolean
) {
    if (stateSubscribe) subscribeTopicNews(true, topicName) else subscribeTopicNews(false, topicName)

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            color = SpaceTechColor.white,
            fontSize = 22.sp,
            modifier = Modifier.align(Alignment.CenterVertically),
            text = textNotification
        )
        Switch(
            modifier = Modifier,
            checked = stateSubscribe,
            onCheckedChange = {
                onClick()
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = SpaceTechColor.white,
                uncheckedTrackColor = SpaceTechColor.navigationElement,
                checkedBorderColor = SpaceTechColor.white,
                checkedThumbColor = SpaceTechColor.darkGreen,
            )
        )
    }
}