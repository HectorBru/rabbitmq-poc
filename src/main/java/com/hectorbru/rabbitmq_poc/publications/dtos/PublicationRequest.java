package com.hectorbru.rabbitmq_poc.publications.dtos;

import java.util.UUID;

public record PublicationRequest(String title, UUID userId) {
}
