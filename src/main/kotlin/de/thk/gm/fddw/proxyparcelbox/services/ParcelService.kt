package de.thk.gm.fddw.proxyparcelbox.services

interface ParcelService {
    fun getEmailByTrackingNumber(trackingNumber: String): String
}