package com.zekierciyas.cache.data

import com.zekierciyas.cache.R
import com.zekierciyas.cache.model.ConversationModel
import com.zekierciyas.cache.model.Message
import com.zekierciyas.cache.model.MessageType

class ConversationsDataProvider {
    var data = listOf(
        ConversationModel(
            id = 1,
            name = "Malena Tudi",
            message = "Hey, how is going?",
            photo = R.drawable.dummy_conversation_1,
            messages = arrayListOf(
                Message(
                    text = "Hey",
                    type = MessageType.RECEIVED
                ),

                Message(
                    text = "hi, good you?",
                    type = MessageType.SENT
                ),

                Message(
                    text = "Hey, how is going?",
                    type = MessageType.RECEIVED
                )
            )
        ),

        ConversationModel(
            id = 2,
            name = "Jakob Curtis",
            message = "Yo, are you going to the Jake’s wedding?",
            photo = R.drawable.dummy_conversation_2,
            messages = arrayListOf(
                Message(
                    text = "Hey",
                    type = MessageType.RECEIVED
                ),

                Message(
                    text = "hi",
                    type = MessageType.SENT
                ),
                Message(
                    text = "Yo, are you going to the Jake’s wedding?",
                    type = MessageType.RECEIVED
                )
            )
        ),

        ConversationModel(
            id = 3,
            name = "Abram Levin",
            message = "Amir said we’d be staying over for a while... but ...",
            photo = R.drawable.dummy_conversation_3,
            messages = arrayListOf(
                Message(
                    text = "Hey",
                    type = MessageType.RECEIVED
                ),

                Message(
                    text = "hi",
                    type = MessageType.SENT
                ),
                Message(
                    text = "Amir said we’d be staying over for a while... but ...",
                    type = MessageType.RECEIVED
                )
            )
        ),

        ConversationModel(
            id = 4,
            name = "Desirae Saris",
            message = "GoT really took a nose dive huh",
            photo = R.drawable.dummy_conversation_5,
            messages = arrayListOf(
                Message(
                    text = "Hey",
                    type = MessageType.RECEIVED
                ),

                Message(
                    text = "hi",
                    type = MessageType.SENT
                ),
                Message(
                    text = "GoT really took a nose dive huh",
                    type = MessageType.RECEIVED
                )
            )
        ),

        ConversationModel(
            id = 5,
            name = "Marilyn Herwitz",
            message = "hey, i got new memes for you",
            photo = R.drawable.dummy_conversation_4,
            messages = arrayListOf(
                Message(
                    text = "Hey",
                    type = MessageType.RECEIVED
                ),

                Message(
                    text = "hi",
                    type = MessageType.SENT
                ),
                Message(
                    text = "hey, i got new memes for you",
                    type = MessageType.RECEIVED
                )
            )
        )
    )
}