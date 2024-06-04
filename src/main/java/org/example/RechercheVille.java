package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class RechercheVille {
    private List<String> villes;

    public RechercheVille(List<String> villes) {
        this.villes = villes;

    }

    public List<String> rechercher(String mot) {
        if (mot.length() < 2) {
            throw new NotFoundException("Le texte de recherche doit contenir au moins 2 caractères");
        }

        if (mot.equals("*")) {
            return villes;
        } else {
            String motLowerCase = mot.toLowerCase();
            return villes.stream()
                    .filter(ville -> ville.toLowerCase().contains(motLowerCase))
                    .collect(Collectors.toList());
        }
    }

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
}