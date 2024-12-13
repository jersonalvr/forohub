package com.alura.challenge.forohub.subject;

public record SubjectDTO(
        Long user_id,
        String course,
        String title,
        String message,
        Boolean enable
) {
}