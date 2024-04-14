package com.example.gallerie.data

import com.example.gallerie.R
import com.example.gallerie.model.Gallery
import com.example.gallerie.model.Picture

class Datasource {
    fun loadGalleries(): List<Gallery> {
        return listOf(
            Gallery(
                R.string.gallery_1,
                listOf(
                    Picture(R.string.tarnier, R.drawable.tarnier),
                    Picture(R.string.oiseau_afrique, R.drawable.oiseau_afrique),
                    Picture(R.string.oiseau_poisson, R.drawable.oiseau_poisson),
                    Picture(R.string.elephant, R.drawable.elephant),
                    Picture(R.string.koudou, R.drawable.koudou),
                    Picture(R.string.brindille, R.drawable.brindille),
                    Picture(R.string.hipopotame, R.drawable.hippopotame),
                    Picture(R.string.gecko, R.drawable.gecko),
                    Picture(R.string.crocodile, R.drawable.crocodile),
                    Picture(R.string.girafon, R.drawable.girafon),
                    Picture(R.string.lemings, R.drawable.lemings),
                    Picture(R.string.vache, R.drawable.vache),
                    Picture(R.string.zebre, R.drawable.zebre),
                    Picture(R.string.zebre_noir_blanc, R.drawable.zebre_noir_blanc),
                    Picture(R.string.elephant_2, R.drawable.oreils_pliees),
                    Picture(R.string.girafe, R.drawable.girafe),
                    Picture(R.string.fleur, R.drawable.fleur),
                    Picture(R.string.chat_langue, R.drawable.chat_langue),
                    Picture(R.string.chat_portrait, R.drawable.chat_portrait),
                    Picture(R.string.oiseau_fleur, R.drawable.oiseau_fleur),
                    Picture(R.string.oiseau_jaune, R.drawable.oiseau_jaune),
                    Picture(R.string.papillon, R.drawable.papillon)
                )
            ),

            Gallery(
                R.string.gallery_2,
                listOf(
                    Picture(R.string.cascade, R.drawable.cascade)
                )
            ),

            Gallery(
                R.string.gallery_3,
                listOf(
                    Picture(R.string.zoulou, R.drawable.zoulou),
                )
            ),

            Gallery(
                R.string.gallery_4,
                listOf(
                    Picture(R.string.nuit_1, R.drawable.nuit_1)
                )
            ),

            Gallery(
                R.string.all_gallerys,
                loadPictures()
            )
        )
    }


    fun loadPictures(): List<Picture> {
        return listOf(
            Picture(R.string.tarnier, R.drawable.tarnier),
            Picture(R.string.oiseau_afrique, R.drawable.oiseau_afrique),
            Picture(R.string.oiseau_poisson, R.drawable.oiseau_poisson),
            Picture(R.string.elephant, R.drawable.elephant),
            Picture(R.string.koudou, R.drawable.koudou),
            Picture(R.string.cascade, R.drawable.cascade),
            Picture(R.string.brindille, R.drawable.brindille),
            Picture(R.string.hipopotame, R.drawable.hippopotame),
            Picture(R.string.gecko, R.drawable.gecko),
            Picture(R.string.crocodile, R.drawable.crocodile),
            Picture(R.string.girafon, R.drawable.girafon),
            Picture(R.string.lemings, R.drawable.lemings),
            Picture(R.string.vache, R.drawable.vache),
            Picture(R.string.zebre, R.drawable.zebre),
            Picture(R.string.zebre_noir_blanc, R.drawable.zebre_noir_blanc),
            Picture(R.string.elephant_2, R.drawable.oreils_pliees),
            Picture(R.string.girafe, R.drawable.girafe),
            Picture(R.string.nuit_1, R.drawable.nuit_1),
            Picture(R.string.fleur, R.drawable.fleur),
            Picture(R.string.chat_langue, R.drawable.chat_langue),
            Picture(R.string.chat_portrait, R.drawable.chat_portrait),
            Picture(R.string.zoulou, R.drawable.zoulou),
            Picture(R.string.oiseau_fleur, R.drawable.oiseau_fleur),
            Picture(R.string.oiseau_jaune, R.drawable.oiseau_jaune),
            Picture(R.string.coquillage, R.drawable.coquillages),
            Picture(R.string.papillon, R.drawable.papillon)
        )
    }
}
