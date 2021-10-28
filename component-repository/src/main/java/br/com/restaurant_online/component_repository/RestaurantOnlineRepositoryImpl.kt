package br.com.restaurant_online.component_repository

import br.com.restaurant_online.component_dto.*
import br.com.restaurant_online.component_network.RestaurantOnlineApi
import br.com.restaurant_online.utils.DisponibilityEnum

class RestaurantOnlineRepositoryImpl(
    private val apiService: RestaurantOnlineApi
) : RestaurantOnlineRepository {
    
    override suspend fun findAllCategories(): List<Category>? {
        val response = apiService.findAllCategories()
        return if(response.isSuccessful) response.body()
        else throw Exception("Erro ao obter categorias da api.")
    }

    override fun findAllCategoriesMock(): List<Category> {
        return listOf(
            Category(
                "Fast Food", listOf(
                    br.com.restaurant_online.component_dto.Food(
                        "Pizza",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            br.com.restaurant_online.component_dto.Image(
                                br.com.restaurant_online.component_dto.ImageFormat(
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg")
                                ),
                                "https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"
                            )
                        )
                    ),
                    Food(
                        "Hamburguer",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            Image(
                                ImageFormat(
                                    ImageType("https://soubh.uai.com.br/uploads/post/image/11558/main_destaque_Alexandr_Popel.jpg"),
                                    ImageType("https://soubh.uai.com.br/uploads/post/image/11558/main_destaque_Alexandr_Popel.jpg"),
                                    ImageType("https://soubh.uai.com.br/uploads/post/image/11558/main_destaque_Alexandr_Popel.jpg"),
                                    ImageType("https://soubh.uai.com.br/uploads/post/image/11558/main_destaque_Alexandr_Popel.jpg")
                                ),
                                "https://soubh.uai.com.br/uploads/post/image/11558/main_destaque_Alexandr_Popel.jpg"
                            )
                        )
                    ),
                    br.com.restaurant_online.component_dto.Food(
                        "Pastel",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            br.com.restaurant_online.component_dto.Image(
                                br.com.restaurant_online.component_dto.ImageFormat(
                                    br.com.restaurant_online.component_dto.ImageType("https://xtudoreceitas.com/wp-content/uploads/Pastel-de-Carne-Temperado.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://xtudoreceitas.com/wp-content/uploads/Pastel-de-Carne-Temperado.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://xtudoreceitas.com/wp-content/uploads/Pastel-de-Carne-Temperado.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://xtudoreceitas.com/wp-content/uploads/Pastel-de-Carne-Temperado.jpg")
                                ),
                                "https://xtudoreceitas.com/wp-content/uploads/Pastel-de-Carne-Temperado.jpg"
                            )
                        )
                    )
                )
            ),
            br.com.restaurant_online.component_dto.Category(
                "Churrasco", listOf(
                    br.com.restaurant_online.component_dto.Food(
                        "Coxão mole",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            br.com.restaurant_online.component_dto.Image(
                                br.com.restaurant_online.component_dto.ImageFormat(
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2021/08/Churrasco-barato.jpg?mode=crop&width={:width=%3E150,%20:height=%3E130}"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2021/08/Churrasco-barato.jpg?mode=crop&width={:width=%3E150,%20:height=%3E130}"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg")
                                ),
                                "https://img.itdg.com.br/tdg/images/blog/uploads/2021/08/Churrasco-barato.jpg?mode=crop&width={:width=%3E150,%20:height=%3E130}"
                            )
                        )
                    ),
                    br.com.restaurant_online.component_dto.Food(
                        "Picanha",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            br.com.restaurant_online.component_dto.Image(
                                br.com.restaurant_online.component_dto.ImageFormat(
                                    br.com.restaurant_online.component_dto.ImageType("https://mhmcdn.manualdohomemmoderno.com.br/?w=781&h=488&quality=100&clipping=crop&url=https://manualdohomemmoderno.com.br/files/2021/07/entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito-entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://mhmcdn.manualdohomemmoderno.com.br/?w=781&h=488&quality=100&clipping=crop&url=https://manualdohomemmoderno.com.br/files/2021/07/entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito-entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://mhmcdn.manualdohomemmoderno.com.br/?w=781&h=488&quality=100&clipping=crop&url=https://manualdohomemmoderno.com.br/files/2021/07/entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito-entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://mhmcdn.manualdohomemmoderno.com.br/?w=781&h=488&quality=100&clipping=crop&url=https://manualdohomemmoderno.com.br/files/2021/07/entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito-entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito.jpg")
                                ),
                                "https://mhmcdn.manualdohomemmoderno.com.br/?w=781&h=488&quality=100&clipping=crop&url=https://manualdohomemmoderno.com.br/files/2021/07/entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito-entenda-qual-e-a-ciencia-por-tras-do-churrasco-perfeito.jpg"
                            )
                        )
                    ),
                    br.com.restaurant_online.component_dto.Food(
                        "Churrasco completo",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            br.com.restaurant_online.component_dto.Image(
                                br.com.restaurant_online.component_dto.ImageFormat(
                                    br.com.restaurant_online.component_dto.ImageType("https://cptstatic.s3.amazonaws.com/imagens/enviadas/materias/materia7011/churrasco-cursos-cpt.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://cptstatic.s3.amazonaws.com/imagens/enviadas/materias/materia7011/churrasco-cursos-cpt.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://cptstatic.s3.amazonaws.com/imagens/enviadas/materias/materia7011/churrasco-cursos-cpt.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://cptstatic.s3.amazonaws.com/imagens/enviadas/materias/materia7011/churrasco-cursos-cpt.jpg")
                                ),
                                "https://cptstatic.s3.amazonaws.com/imagens/enviadas/materias/materia7011/churrasco-cursos-cpt.jpg"
                            )
                        )
                    )
                )
            ),
            br.com.restaurant_online.component_dto.Category(
                "Bebidas", listOf(
                    br.com.restaurant_online.component_dto.Food(
                        "suco de laranja",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            br.com.restaurant_online.component_dto.Image(
                                br.com.restaurant_online.component_dto.ImageFormat(
                                    br.com.restaurant_online.component_dto.ImageType(
                                        "data:image/jpeg;base64,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"
                                    ),
                                    br.com.restaurant_online.component_dto.ImageType(
                                        "data:image/jpeg;base64,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"
                                    ),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2021/08/Churrasco-barato.jpg?mode=crop&width={:width=%3E150,%20:height=%3E130}"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2021/08/Churrasco-barato.jpg?mode=crop&width={:width=%3E150,%20:height=%3E130}")
                                ),
                                "https://img.itdg.com.br/tdg/images/blog/uploads/2021/08/Churrasco-barato.jpg?mode=crop&width={:width=%3E150,%20:height=%3E130}"
                            )
                        )
                    ),
                    br.com.restaurant_online.component_dto.Food(
                        "Suco de angrião",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            br.com.restaurant_online.component_dto.Image(
                                br.com.restaurant_online.component_dto.ImageFormat(
                                    br.com.restaurant_online.component_dto.ImageType("https://t2.rg.ltmcdn.com/pt/images/5/1/0/suco_de_agriao_8015_orig.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://t2.rg.ltmcdn.com/pt/images/5/1/0/suco_de_agriao_8015_orig.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg")
                                ),
                                "https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"
                            )
                        )
                    ),
                    br.com.restaurant_online.component_dto.Food(
                        "Suco de morango",
                        "",
                        27.0,
                        true,
                        DisponibilityEnum.ACTIVE,
                        listOf(
                            br.com.restaurant_online.component_dto.Image(
                                br.com.restaurant_online.component_dto.ImageFormat(
                                    br.com.restaurant_online.component_dto.ImageType("https://1.bp.blogspot.com/-PLOd1ScdHe0/XPAzW2DVn4I/AAAAAAAAD2c/I5mFRrAuy7cBPtp0TZCe-ng10Ron-I_MwCLcBGAs/s1600/Suco%2Bde%2BMel%25C3%25A3o%252C%2BMorango%2Be%2BHortel%25C3%25A3.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://1.bp.blogspot.com/-PLOd1ScdHe0/XPAzW2DVn4I/AAAAAAAAD2c/I5mFRrAuy7cBPtp0TZCe-ng10Ron-I_MwCLcBGAs/s1600/Suco%2Bde%2BMel%25C3%25A3o%252C%2BMorango%2Be%2BHortel%25C3%25A3.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"),
                                    br.com.restaurant_online.component_dto.ImageType("https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg")
                                ),
                                "https://img.itdg.com.br/tdg/images/blog/uploads/2019/05/pizza.jpg"
                            )
                        )
                    )
                )
            )
        )
    }
}