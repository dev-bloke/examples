package com.meridal.examples.recordcollection.repository;

import com.meridal.examples.recordcollection.domain.discogs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Repository
public class DiscogsRepository {

    private static final Logger LOG = LoggerFactory.getLogger(DiscogsRepository.class);
    private static final String ARTIST = "/artists/";
    private static final String MASTER = "/masters/";
    private static final String PRICE = "/marketplace/price_suggestions/";
    private static final String PER_PAGE = "per_page";
    private static final String RELEASE = "/releases/";
    private static final String SEARCH = "/database/search";
    private static final String TERM = "q";
    private static final String TYPE = "type";
    private static final String TYPE_ARTIST = "artist";
    private static final String TYPE_MASTER = "master";
    private static final String VERSIONS = "/versions";

    private final String baseUrl;
    private final WebClient client;
    private final String keySecret;
    private final Integer pageSize;
    private final String token;

    public DiscogsRepository(
        @Value("${discogs.baseUrl}") final String baseUrl,
        @Value("${discogs.keySecret}") final String keySecret,
        @Value("${discogs.pageSize:100}") final Integer pageSize,
        @Value("${discogs.token}") final String token) {
        this.baseUrl = baseUrl;
        this.client = this.createWebClient(this.baseUrl);
        this.keySecret = keySecret;
        this.pageSize = pageSize;
        this.token = token;
        this.logConfig();
    }

    public void logConfig() {
        LOG.debug("baseUrl={}", this.baseUrl);
        LOG.debug("keySecret={}", this.keySecret);
        LOG.debug("pageSize={}", this.pageSize);
        LOG.debug("token={}", this.token);
    }

    public Artist getArtistByID(final String id) {
        final ResponseSpec responseSpec = this.getResponseSpec(ARTIST + id, this.keySecret);
        return responseSpec.bodyToMono(Artist.class).block();
    }

    public Master getMasterByID(final String id) {
        return this.getMasterByID(id, null, null);
    }

    public Master getMasterByID(final String id, final String country, final String format) {
        final String url = this.getMasterUrl(id, country, format);
        final ResponseSpec responseSpec = this.getResponseSpec(url, this.token);
        return responseSpec.bodyToMono(Master.class).block();
    }

    protected String getMasterUrl(final String id, final String country, final String format) {
        return UriComponentsBuilder.fromPath(MASTER + id + VERSIONS)
            .queryParamIfPresent("country", Optional.ofNullable(country))
            .queryParamIfPresent("format", Optional.ofNullable(format))
            .toUriString();
    }

    public Release getReleaseByID(final String id) {
        final ResponseSpec responseSpec = this.getResponseSpec(RELEASE + id, this.keySecret);
        return responseSpec.bodyToMono(Release.class).block();
    }

    public PriceSuggestion getPriceSuggestionByID(final String id) {
        final ResponseSpec responseSpec = this.getResponseSpec(PRICE + id, this.token);
        return responseSpec.bodyToMono(PriceSuggestion.class).block();
    }

    public SearchResults searchForArtist(final String searchTerm) {
        return this.searchFor(searchTerm, TYPE_ARTIST);
    }

    public SearchResults searchForMaster(final String searchTerm) {
        return this.searchFor(searchTerm, TYPE_MASTER);
    }

    private SearchResults searchFor(final String searchTerm, final String type) {
        final String url = this.getSearchUrl(searchTerm, type);
        LOG.debug("url={}",url);
        final ResponseSpec responseSpec = this.getResponseSpec(url , this.keySecret);
        return responseSpec.bodyToMono(SearchResults.class).block();
    }

    protected String getSearchUrl(final String searchTerm, final String type) {
        return UriComponentsBuilder.fromPath(SEARCH)
            .queryParamIfPresent(TERM, Optional.ofNullable(searchTerm))
            .queryParamIfPresent(TYPE, Optional.ofNullable(type))
            .queryParamIfPresent(PER_PAGE, Optional.ofNullable(this.pageSize))
            .toUriString();
    }

    private WebClient createWebClient(final String baseUrl) {
        return WebClient.builder()
            .baseUrl(baseUrl)
            .build();
    }

    private ResponseSpec getResponseSpec(final String uri, final String authorization) {
        return this.client.get()
            .uri(uri)
            .header("Authorization", authorization)
            .retrieve();
    }
}
