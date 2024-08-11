package de.thk.gm.fddw.proxyparcelbox.services

import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class ParcelServiceImpl (private val client : HttpClient = HttpClient.newBuilder().build()) : ParcelService{
    override fun getEmailByTrackingNumber(trackingNumber: String): String {
        val request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://fddwsenguel.free.beeceptor.com/parcels/${trackingNumber}"))
            .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json: JSONObject = JSONObject(response.body())

        return json.getString("email")
    }
}

