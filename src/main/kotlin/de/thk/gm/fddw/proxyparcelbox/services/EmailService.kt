package de.thk.gm.fddw.proxyparcelbox.services

interface EmailService {
    fun sendSimpleMessage(email: String, subject:String, message: String)
    fun sendConfirmationEmail(email: String, trackingnumber: String)
    fun sendAbonnementConfirmation(email: String, trackingnumber: String, message: String)
}