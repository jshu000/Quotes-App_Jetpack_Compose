package com.andha_coder.firstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(heightDp = 500)
@Composable
fun previewItem(){
    LazyColumn(content = {
        items(getCategoryList()){item ->
            BlogCategory(imgid = item.imgid, name = item.name, subtitle = item.subtitle)
        }
    })

}

@Composable
fun BlogCategory(imgid :Int,name :String, subtitle: String) {
    Card {
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(imgid),
                contentDescription = "Dummy pic",
                Modifier.size(40.dp)
            )
            Column {
                Text(text = name)
                Text(text = subtitle)
            }
        }
    }

}

data class Category(val imgid: Int,val name: String,val subtitle:String){
    
}
fun getCategoryList(): MutableList<Category> {
    val list= mutableListOf<Category>()
    list.add(Category( R.drawable.man,  "Jashwant", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant2", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant3", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant11", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant22", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant33", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant111", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant222", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant333", "Software"))

    list.add(Category( R.drawable.man,  "Jashwant", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant2", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant3", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant11", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant22", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant33", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant111", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant222", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant333", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant2", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant3", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant11", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant22", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant33", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant111", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant222", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant333", "Software"))

    list.add(Category( R.drawable.man,  "Jashwant", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant2", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant3", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant11", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant22", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant33", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant111", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant222", "Software"))
    list.add(Category( R.drawable.man,  "Jashwant333", "Software"))
    return list

}