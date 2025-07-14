package com.example.sportsteam.data

import com.example.sportsteam.Player

val snoopyImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/snoopy.jpg"
val lucyImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/lucy.jpg"
val charlieImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/charlie_brown.jpg"
val woodstockImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/woodstock.jpg"

val franklinImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/franklin.jpg"
val linusImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/linus.jpg"
val marcieImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/marcie.jpeg"
val peppermintPattyImageUrl =
    "https://ciaralooney.netlify.app/app_images/snoopy_app/peppermint_patty.jpg"
val schroederImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/schroeder.jpg"
val sallyImageUrl = "https://ciaralooney.netlify.app/app_images/snoopy_app/sally.jpg"


val players = listOf(
    Player(
        snoopyImageUrl, "Snoopy", "Shortstop",
        "Hero", "In one season he ate: 24 pre-game meals, 19 mid-game meals," +
                " 54 post game meals and 300 packs of bubble gum"
    ),

    Player(
        lucyImageUrl, "Lucy", "Right Field",
        "Ham & Cheese", "In one season 98 fly balls bounced over her head, " +
                "76 grounders rolled through her legs and she dropped 200 fly balls"
    ),

    Player(
        charlieImageUrl, "Charlie Brown", "Manager/Pitcher",
        "Peanut Butter & Jelly", "When Charlie Brown developed Little Leaguer's" +
                " Elbow, Linus took over as pitcher. The team didn't lose another game until" +
                " Charlie Brown returned to pitch"
    ),

    Player(
        woodstockImageUrl, "Woodstock", "Designated Hitter",
        "Bread Crusts",
        "Woodstock is by far the smallest player on the team. He always draws a base " +
                "on balls when he gets his turn at bat. " +
                "That is if the ball doesn't roll over him."
    ),

    Player(
        franklinImageUrl, "Franklin",
        "First Base", "Grilled Cheese", "Since Franklin is good at " +
                "baseball he is not in Charlie's team. " +
                "He plays on Patty's baseball team and brings a " +
                "calm composure to an otherwise chaotic team."
    ),

    Player(
        linusImageUrl, "Linus", "Second Base",
        "Tuna Salad", "Although Linus is one of the better players, " +
                "he often has untied shoelaces and falls when he runs."
    ),

    Player(
        marcieImageUrl, "Marcie", "Right Field",
        "Veggie", "She doesn't understand the terminology of the game sometimes" +
                " confusing the home plate with dinner plates"
    ),

    Player(
        peppermintPattyImageUrl, "Peppermint Patty", "Manager/Pitcher",
        "Bologna", "Patty originally joined Charlie's team as a pitcher but she quit in disgust" +
                " after only one game. She formed her own team and regularly" +
                " trounces Charlie's team"
    ),

    Player(
        schroederImageUrl, "Schroeder", "Catcher",
        "Turkey", "When their team was required to have a sponsor to play " +
                "games, Schroeder chose the composer Beethoven as a sponsor."
    ),

    Player(
        sallyImageUrl, "Sally", "Third Base",
        "Cream Cheese & Jelly", "When Charlie Brown gets lost in the forest Sally" +
                " writes a get well card to" +
                " him saying she moved into his room and then she sold all of his stuff "
    ),
)