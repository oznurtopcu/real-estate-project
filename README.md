# 🏠 Real Estate Management System

Bu proje, bir **emlak işletmesinin kayıt, müşteri ve ilan yönetimi** süreçlerini yöneten tam katmanlı bir **Spring Boot + React** uygulamasıdır.  

---

## 📋 Proje Özeti

Sistem üç temel modülden oluşur:

1. **Company (İşyeri) Yönetimi**
   - Emlak işletmesinin adı, yetkilisi, adresi, iletişim bilgileri tutulur.

2. **Customer (Müşteri) Yönetimi**
   - Emlak alan, satan, kiralayan veya kiraya veren müşterilerin bilgileri kaydedilir.

3. **Listing (Emlak / İlan) Yönetimi**
   - Müşterilere ait satılık veya kiralık emlak kayıtları tutulur.  
   - Alan, oda sayısı, kat, bina katı, ısınma tipi, fiyat vb. bilgiler içerir.
   - İlanlar arasında **filtreli arama** yapılabilir.

---

## ⚙️ Kullanılan Teknolojiler

### 🖥️ Backend
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA / Hibernate**
- **PostgreSQL**
- **Lombok**
- **Spring Boot Validation**

### 💻 Frontend
- **React.js**
- **Axios** (REST API entegrasyonu)
- **TailwindCSS / Bootstrap**
- **React Router** (sayfa geçişleri)
- **Github Repo** - https://github.com/oznurtopcu/real-estate-frontend

---

## 🚀 API Örnekleri

### 🔸 1. Emlak İlanı Kaydetme

**POST** `/api/listing`

```json
{
  "type": "Kiralık",
  "room_info": "3+1",
  "area": 120,
  "floor": 2,
  "building_floor": 5,
  "heating_type": "Doğalgaz",
  "price": 18000,
  "description": "Merkezi konumda, geniş balkonlu daire",
  "company_id": 1,
  "customer_id": 2
}

```

### 🔸 2. Emlak İlanı Filtreleme

**POST** `/api/listing/search`

```json
{
  "type": "Kiralık",
  "roomInfo": "2+1",
  "minPrice": 10000,
  "maxPrice": 20000,
  "heatingType": "Doğalgaz"
}

```

## 🧱 Veri Tabanı Tasarımı

**İlişkiler:**

| Tablo     | İlişki | Açıklama |
|-----------|--------|----------|
| `company` | 1 → N  | Her işletme birçok ilan kaydedebilir |
| `listing` | N → 1  | Her ilan bir müşteriye ait olabilir |
| `customer`| 1 → N  | Müşteri birden fazla ilan verebilir |

---

## 🧾 Ek Özellikler

- 🔍 **Filtreli Arama**  
  - POST `/api/listing/search` endpoint’i ile kriterlere göre ilanlar listelenebilir.
- 🧱 **DTO Yapısı**  
  - Temiz veri transferi için DTO sınıfları kullanılmıştır.
- 🏗️ **Katmanlı Mimari**  
  - Controller → Service → Repository mantığı ile uygulanmıştır.
- ⚙️ **Exception Handling**  
  - Hatalar uygun şekilde yönetilmektedir.
