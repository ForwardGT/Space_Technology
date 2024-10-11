package com.example.spacetechnology.features.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.view.CustomSpacer

@Composable
fun AboutAppViewContent() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
    ) {

        MainHeadline(text = "SpaceX and NASA: Pioneering Technologies in Space Exploration")

        SecondHeadline(text = "Introduction")

        TextContent(text = "Space exploration has seen remarkable advancements thanks to the pioneering technologies developed by SpaceX and NASA. Both organizations have made significant contributions to our understanding of space and our ability to explore it, pushing the boundaries of what is possible.")

        MainHeadline(text = "SpaceX Technologies")

        SecondHeadline(text = "Reusable Rockets")

        TextContent(text = "One of SpaceX's most groundbreaking innovations is the development of reusable rockets. The Falcon 9, for instance, is designed to return to Earth and be relaunched multiple times, significantly reducing the cost of space travel. This technology not only makes space missions more economical but also opens the door for more frequent and sustainable exploration.")

        SecondHeadline(text = "Starship")

        TextContent(text = "SpaceX's Starship is an advanced spacecraft designed for missions to Mars and beyond. With the capability to carry both crew and cargo, Starship represents a major leap forward in deep space exploration. It is designed to be fully reusable and aims to facilitate human settlement on other planets.")

        SecondHeadline(text = "Dragon Spacecraft")

        TextContent(text = "The Dragon spacecraft is another key innovation by SpaceX. It is capable of carrying humans to the International Space Station (ISS) and beyond. The Crew Dragon variant, in particular, has revolutionized crewed missions with its state-of-the-art safety features and advanced automation.")

        MainHeadline(text = "NASA Technologies")

        SecondHeadline(text = "Space Launch System (SLS)")

        TextContent(text = "NASA's Space Launch System (SLS) is a powerful, heavy-lift rocket designed for deep space missions. It is the backbone of NASA's Artemis program, which aims to return humans to the Moon and eventually send astronauts to Mars. The SLS is designed to be flexible and evolvable, capable of carrying various payloads and crew.")

        SecondHeadline(text = "Orion Spacecraft")

        TextContent(text = "The Orion spacecraft is designed to carry astronauts farther into space than ever before. Equipped with advanced life support systems, navigation, and propulsion, Orion is central to NASA's plans for deep space exploration. It will work in conjunction with the SLS to facilitate human missions to the Moon, Mars, and beyond.")

        SecondHeadline(text = "Mars Rovers")

        TextContent(text = "NASA's Mars rovers, including the latest Perseverance rover, are equipped with cutting-edge technology to explore the Martian surface. These rovers are designed to conduct scientific experiments, search for signs of past life, and prepare for future human missions. They are equipped with advanced cameras, scientific instruments, and autonomous navigation systems.")

        SecondHeadline(text = "Collaborative Efforts")

        TextContent(text = "SpaceX and NASA often collaborate on missions, combining their expertise to achieve greater success. The Commercial Crew Program is a prime example, where SpaceX's Crew Dragon spacecraft is used to transport astronauts to the ISS, marking a new era of commercial spaceflight.")

        SecondHeadline(text = "Conclusion")

        TextContent(text = "SpaceX and NASA are at the forefront of space technology, each contributing uniquely to the advancement of space exploration. SpaceX's innovations in reusable rockets and spacecraft are making space more accessible and affordable, while NASA's development of powerful rockets and sophisticated spacecraft is paving the way for deep space missions. Together, these organizations are shaping the future of space travel, pushing the limits of human exploration and expanding our understanding of the universe.")

    }

}


@Composable
private fun MainHeadline(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = SpaceTechColor.white,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        text = text
    )
    CustomSpacer(v = 6.dp)
}

@Composable
private fun SecondHeadline(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = SpaceTechColor.white,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        text = text
    )
    CustomSpacer(v = 1.dp)
}

@Composable
private fun TextContent(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = SpaceTechColor.white,
        text = text
    )
    CustomSpacer(v = 6.dp)
}