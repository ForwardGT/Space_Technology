package com.example.spacetechnology.features.nasa.data.mapper

import com.example.spacetechnology.features.nasa.data.model.PostsTechTransferDto
import com.example.spacetechnology.features.nasa.domain.entity.PostTechTransfer

fun PostsTechTransferDto.mapperTechNasa(): List<PostTechTransfer> {

    val posts = mutableListOf<PostTechTransfer>()

    val regex = """<span\s+class=["']highlight["']>.*?</span>""".toRegex()

    this.results.forEach {
        val post = PostTechTransfer(
            name = it[1],
            description = it[3].replace(regex, ""),
            image = it[10]
        )
        posts.add(post)
    }
    return posts
}