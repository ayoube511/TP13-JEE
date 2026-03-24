# 🔐 OAuth2 Client — Spring Boot + Google

> Authentification déléguée avec **Google OAuth2 / OpenID Connect** — Spring Boot 3 + Spring Security + Thymeleaf

![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-brightgreen?style=flat-square&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-darkgreen?style=flat-square&logo=springsecurity)
![OAuth2](https://img.shields.io/badge/OAuth2-OpenID%20Connect-blue?style=flat-square)
![Google](https://img.shields.io/badge/Google-Identity-red?style=flat-square&logo=google)

---

## 📋 Description

Application Spring Boot qui délègue l'authentification à **Google** via le protocole **OAuth2 / OpenID Connect**.  
L'utilisateur se connecte avec son compte Google — aucun mot de passe n'est stocké dans l'application.

---

## 🔄 Flux OAuth2 / OIDC

Utilisateur clique "Se connecter avec Google"
              ↓
Spring Security redirige vers accounts.google.com
              ↓
Utilisateur s'authentifie sur Google
              ↓
Google renvoie un code d'autorisation
              ↓
Spring échange le code contre :
  - Access Token  → accès aux ressources
  - ID Token (JWT) → identité utilisateur
              ↓
Profil affiché : nom, email, photo
```

---

## ✨ Fonctionnalités

- 🔵 Connexion avec **Google** en un clic
- 👤 Affichage du profil : nom, email, photo
- 🔒 Aucun mot de passe stocké dans l'application
- 🚪 Déconnexion propre avec suppression de session
- 🎨 Interface moderne avec Thymeleaf

---

## 🏗️ Structure du projet

src/main/java/ma/ens/security/
├── config/
│   └── SecurityConfig.java        # Configuration OAuth2 + règles d'accès
├── web/
│   └── HomeController.java        # Extraction des infos du ID Token
└── Oauth2ClientApplication.java

src/main/resources/
├── application.yml                # Config OAuth2 Google
└── templates/
    ├── index.html                 # Page d'accueil
    ├── login.html                 # Page de connexion
    └── profile.html               # Profil utilisateur
```

---

## 🛠️ Technologies

| Technologie | Rôle |
|---|---|
| Spring Boot 3.3 | Framework principal |
| Spring Security 6 | Gestion OAuth2 |
| OAuth2 Client | Intégration Google |
| OpenID Connect | Récupération identité |
| Thymeleaf | Templates HTML |
| Google Cloud | Fournisseur d'identité |

---

## ⚙️ Prérequis

- ✅ JDK 17+
- ✅ Maven 3.x
- ✅ Un compte Google
- ✅ Un projet Google Cloud avec OAuth2 configuré
- ❌ Pas besoin de MySQL
- ❌ Pas besoin de Tomcat

---

## 🚀 Configuration & Lancement

### 1. Créer les credentials Google Cloud

1. Aller sur **https://console.cloud.google.com**
3. Créer un projet → **API et services → Identifiants**
4. Créer un **ID client OAuth 2.0** (Application Web)
<img width="1919" height="923" alt="image" src="https://github.com/user-attachments/assets/2a113f30-5e7e-4e81-80ba-a71c3673a0d5" />
5. Ajouter l'URI de redirection :
<img width="1919" height="923" alt="image" src="https://github.com/user-attachments/assets/e6e70def-2e57-42bf-a672-4b1dbcf0f025" />

---

## ## 🧪 Test

1. Ouvre `http://localhost:8081`
<img width="1920" height="1080" alt="Capture d’écran (332)" src="https://github.com/user-attachments/assets/7f3a56a5-19cb-4676-80a1-3bd8b3163b6d" />
2. Clique **"Se connecter avec Google"**
<img width="1919" height="1031" alt="Capture d&#39;écran 2026-03-23 125502" src="https://github.com/user-attachments/assets/44826170-b451-4d59-9d31-3562f2533aea" />
3. Connecte-toi avec ton compte Google
<img width="1919" height="1032" alt="Capture d&#39;écran 2026-03-23 125515" src="https://github.com/user-attachments/assets/e94552f0-8ef2-4625-a6fd-5e22dcfd8b8a" />
4. Le profil s'affiche avec nom, email et photo ✅
<img width="1919" height="931" alt="Capture d&#39;écran 2026-03-23 125533" src="https://github.com/user-attachments/assets/6f244aaa-d86c-4cb5-8137-90774a8c6f42" />

---


## 🆚 Comparaison avec les TPs précédents

| | TP Security 1-2 | TP JWT | TP OAuth2 (ce projet) |
|---|---|---|---|
| Stockage users | Mémoire / MySQL | MySQL | ❌ **Aucun** |
| Mot de passe | Oui | Oui | ❌ **Délégué à Google** |
| Token | Session | JWT | **ID Token Google** |
| Login | Formulaire HTML | API REST | **Compte Google** |

---

## 👨‍💻 Auteur

**Ayoub Moubssite**  
TP13 — OAuth2 / OpenID Connect avec Google et Spring Boot

---

> ⚠️ Ne jamais committer le `client-secret` dans Git !  
> Utilise des variables d'environnement en production.
