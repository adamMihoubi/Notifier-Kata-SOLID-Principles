## 📬 Kata — *"Notifie-moi"*

### Contexte

Une startup propose une plateforme de gestion d'événements. Quand quelque chose de notable se produit (inscription d'un utilisateur, paiement reçu, rappel d'événement...), la plateforme doit en **notifier les bonnes personnes, au bon moment, par le bon canal**.

---

### 🧩 Besoin 1 — Le minimum viable

L'équipe veut pouvoir envoyer un message email à un utilisateur depuis n'importe quel endroit dans le code. Le message contient un sujet, un corps de texte, et l'adresse du destinataire. Chaque envoi doit être **tracé dans un fichier de log** avec l'heure et le destinataire.

---

### 🧩 Besoin 2 — Nouveaux canaux

Le product owner revient avec une nouvelle demande : certains utilisateurs préfèrent recevoir des **SMS**, d'autres des **notifications push** sur mobile. La plateforme doit supporter les trois canaux. Un utilisateur a **un canal préféré** dans son profil.

---

### 🧩 Besoin 3 — Canal dégradé

Pour optimiser les coûts, l'équipe introduit un canal email "économique" qui **refuse d'envoyer si plus de 100 emails ont été envoyés dans l'heure**. Ce canal doit pouvoir remplacer le canal email standard dans tous les cas d'usage existants, sans que le reste du système ait besoin de le savoir.

---

### 🧩 Besoin 4 — Planification

L'équipe veut permettre de **planifier une notification à l'avance** (ex: rappel 24h avant un événement) et de **l'annuler** si l'événement est supprimé entre-temps. Certains canaux supportent cette fonctionnalité, d'autres non — le SMS basique, par exemple, envoie immédiatement et ne peut pas être annulé.

---

### 🧩 Besoin 5 — Branchement de nouveaux fournisseurs

L'entreprise change de fournisseur email. Demain, elle pourrait changer de fournisseur SMS. Le système doit permettre de **brancher un nouveau fournisseur sans modifier la logique de notification** elle-même — juste en changeant ce qui est "branché" au démarrage de l'application.

---

### ✅ Livrable final

Un système capable d'envoyer, planifier et annuler des notifications multi-canaux, où **ajouter le support de Slack** pour une nouvelle catégorie d'utilisateurs se fait en une seule extension, sans retoucher ce qui existe déjà.

---

Le but du kata est de respecter les principes SOLID. 🧱