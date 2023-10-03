package com.example.spacee.navigation

interface Destinations
{
    val route:String
}
object Login: Destinations {
    override val route="Login"
}
object Chat: Destinations {
    override val route="Chat"
}
object Call: Destinations {
    override val route="Call"
}
object Profile: Destinations {
    override val route="Profile"
}
object Settings: Destinations {
    override val route="Settings"
}