package moj.memes.domain

import moj.memes.base.network.model.WheatherDto
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun map(dto: WheatherDto): WheatherDto {
        return dto
    }
}
