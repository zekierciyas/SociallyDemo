package com.zekierciyas.cache.data

import com.zekierciyas.cache.R
import com.zekierciyas.cache.model.ConversationModel

class ConversationsDataProvider {
    var data = listOf(
        ConversationModel(
            id = 1,
            name = "Malena Tudi",
            message = "Hey, how is going?",
            photo = R.drawable.dummy_conversation_1
        ),

        ConversationModel(
            id = 2,
            name = "Jakob Curtis",
            message = "Yo, are you going to the Jake’s wedding?",
            photo = R.drawable.dummy_conversation_2
        ),

        ConversationModel(
            id = 3,
            name = "Abram Levin",
            message = "Amir said we’d be staying over for a while... but ...",
            photo = R.drawable.dummy_conversation_3
        ),

        ConversationModel(
            id = 4,
            name = "Desirae Saris",
            message = "GoT really took a nose dive huh",
            photo = R.drawable.dummy_conversation_5
        ),

        ConversationModel(
            id = 5,
            name = "Marilyn Herwitz",
            message = "hey, i got new memes for you",
            photo = R.drawable.dummy_conversation_4
        )
    )
}