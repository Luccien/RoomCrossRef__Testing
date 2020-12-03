package eu.de.servicetestfragment.framework.db.profile

import eu.de.core.usecase.profile.AddProfile
import eu.de.core.usecase.profile.GetAllProfile

data class ProfileUseCases (
    val addProfile: AddProfile,
    val getAllProfile: GetAllProfile

){
}