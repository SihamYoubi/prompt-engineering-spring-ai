# AI Project with Spring Boot & OpenAI

Ce projet est une application Spring Boot qui intègre **Spring AI** pour interagir avec les modèles d'OpenAI.  
Elle permet de tester différentes capacités de l'IA comme la génération de texte, le streaming, l'analyse d'image, et la génération d'images.

## Fonctionnalités

### 1. AIAgentController
Un contrôleur simple pour tester des requêtes textuelles avec OpenAI.

- Endpoint : `http://localhost:{port}/ask`
- Description : Envoie une question à l'IA via un prompt simple.
- Exemple : `http://localhost:{port}/ask?query=Quel est le meilleur film documentaire en 2025`

---

### 2. AIAgentStructuredController
Un contrôleur qui structure la réponse de l'IA dans une classe Java (`MovieList`).

- Endpoint : `http://localhost:{port}/askAgent`
- Description : Envoie une question sur le cinéma, réponse typée.
- Exemple : `http://localhost:{port}/askAgent?query=Quels sont les films documentaires récents`

---

### 3. StreamingController
Permet de streamer les réponses de l'IA mot par mot.

- Endpoint : `http://localhost:{port}/stream`
- Description : Affiche la réponse de l'IA en direct (streaming).
- Exemple : `http://localhost:{port}/stream?query=Raconte une blague`

---

### 4. MultiModalController
Permet d'extraire des informations depuis une image en utilisant les capacités multimodales d'OpenAI.

- Endpoint : `http://localhost:{port}/askImage`
- Méthode : `POST` (avec une image en fichier multipart)
- Description : Analyse le contenu d’une image (ex : image d’une facture).

---

### 5. Image Generation
Fonctionnalité de génération d'images à partir d'une description textuelle.

- Endpoint : `http://localhost:{port}/generate-image`
- Description : Génère une image via OpenAI DALL·E.
- Exemple : `http://localhost:{port}/generate-image?prompt=chat assis sur une planète`

---

## Technologies utilisées

- Java 21
- Spring Boot
- Spring AI
- OpenAI
- Swagger UI


