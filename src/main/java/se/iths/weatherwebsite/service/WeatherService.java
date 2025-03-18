package se.iths.weatherwebsite.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @org.springframework.beans.factory.annotation.Value("${weatherapi.key}")
    private String apiKey;

    @Value("${weather.api.base-url}")
    private String baseUrl;

    public String fetchWeather(String city) {
        String url = baseUrl + "?key=" + apiKey + "&q=" + city + "&aqi=no";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
