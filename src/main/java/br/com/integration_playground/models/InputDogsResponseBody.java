package br.com.integration_playground.models;

import java.util.List;

public record InputDogsResponseBody(List<String> facts, boolean success) {
}