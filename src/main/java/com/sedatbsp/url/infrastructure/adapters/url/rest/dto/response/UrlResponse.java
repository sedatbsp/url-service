package com.sedatbsp.url.infrastructure.adapters.url.rest.dto.response;

import com.sedatbsp.url.domain.common.model.Status;
import com.sedatbsp.url.domain.url.model.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlResponse {

    private Long id;

    private String url;

    private String shortenedUrl;

    private LocalDateTime expirationDate;

    private Status status;

    public static UrlResponse fromModel(Url url) {
        return UrlResponse
                .builder()
                .id(url.getId())
                .url(url.getUrl())
                .shortenedUrl(url.getShortenedUrl())
                .expirationDate(url.getExpirationDate())
                .status(url.getStatus())
                .build();
    }


    public static List<UrlResponse> fromListOfModel(List<Url> urls) {
        return urls.stream().map(UrlResponse::fromModel).collect(Collectors.toList());
    }

}
