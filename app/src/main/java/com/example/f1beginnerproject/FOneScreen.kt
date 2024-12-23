package com.example.f1beginnerproject

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.f1beginnerproject.model.F1item
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.f1beginnerproject.model.FOneRepository

@Composable
fun FOneListItem(fOneItem : F1item,modifier: Modifier = Modifier){
    var expanded by remember {
        mutableStateOf(false)
    }

    val color by animateColorAsState(
        targetValue = if(expanded) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.primaryContainer
    )

    val textcolor by animateColorAsState(targetValue = if(expanded) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.tertiary)
    Card(
        modifier = modifier
            .clickable { expanded = !expanded }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = color,
            
        )

    ) {
        Column(
            modifier = modifier
        ){
            Text(
                text = stringResource(id = fOneItem.titleRes),
                style = MaterialTheme.typography.displayLarge,
                color = textcolor
            )
            Image(
                painter = painterResource(id = fOneItem.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            )
            if(expanded){
                Text(
                    text = stringResource(id = fOneItem.referenceRes),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Text(
                    text = stringResource(id = fOneItem.contentRes),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer)
            }

        }
    }

}


@Composable
fun F1List( modifier : Modifier = Modifier){
    val f1List = FOneRepository.f1items

    LazyColumn(modifier = modifier) {
        items(f1List){ F1item->
            FOneListItem(
                fOneItem = F1item,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun F1Screen(modifier: Modifier=Modifier){
    Scaffold(
        topBar = { F1TopAppBar() }
    ) { paddingValues->
       F1List(modifier = modifier.padding(paddingValues))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun F1TopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "FORMULA 1",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )

    },
    modifier = modifier
        )
}

@Preview
@Composable
fun listItemPreview(){
    FOneListItem(
        fOneItem = F1item(
            titleRes = R.string.day_1_title,
            imageRes = R.drawable.gettyimages_2168307820_612x612,
            referenceRes = R.string.day_1_reference,
            contentRes = R.string.day_1_content
        )
    )
}

@Preview
@Composable
fun listPreview(){
    F1Screen()
}