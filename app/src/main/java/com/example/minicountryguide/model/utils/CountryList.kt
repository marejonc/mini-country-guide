package com.example.minicountryguide.model.utils

object CountryList {
    private val countries = arrayListOf(
        listOf("AFG", "Afganistan"),
        listOf("ALB", "Albania"),
        listOf("DZA", "Algieria"),
        listOf("AND", "Andora"),
        listOf("AGO", "Angola"),
        listOf("ATG", "Antigua i Barbuda"),
        listOf("SAU", "Arabia Saudyjska"),
        listOf("ARG", "Argentyna"),
        listOf("ARM", "Armenia"),
        listOf("AUS", "Australia"),
        listOf("AUT", "Austria"),
        listOf("AZE", "Azerbejdżan"),
        listOf("BHS", "Bahamy"),
        listOf("BHR", "Bahrajn"),
        listOf("BGD", "Bangladesz"),
        listOf("BRB", "Barbados"),
        listOf("BEL", "Belgia"),
        listOf("BLZ", "Belize"),
        listOf("BEN", "Benin"),
        listOf("BTN", "Bhutan"),
        listOf("BLR", "Białoruś"),
        listOf("BOL", "Boliwia"),
        listOf("BIH", "Bośnia i Hercegowina"),
        listOf("BWA", "Botswana"),
        listOf("BRA", "Brazylia"),
        listOf("BRN", "Brunei"),
        listOf("BGR", "Bułgaria"),
        listOf("BFA", "Burkina Faso"),
        listOf("BDI", "Burundi"),
        listOf("CHL", "Chile"),
        listOf("CHN", "Chiny"),
        listOf("HRV", "Chorwacja"),
        listOf("CYP", "Cypr"),
        listOf("TCD", "Czad"),
        listOf("MNE", "Czarnogóra"),
        listOf("CZE", "Czechy"),
        listOf("DNK", "Dania"),
        listOf("COD", "Demokratyczna Republika Konga"),
        listOf("DMA", "Dominika"),
        listOf("DOM", "Dominikana"),
        listOf("DJI", "Dżibuti"),
        listOf("EGY", "Egipt"),
        listOf("ECU", "Ekwador"),
        listOf("ERI", "Erytrea"),
        listOf("EST", "Estonia"),
        listOf("SWZ", "Eswatini"),
        listOf("ETH", "Etiopia"),
        listOf("FJI", "Fidżi"),
        listOf("PHL", "Filipiny"),
        listOf("FIL", "Finlandia"),
        listOf("FRA", "Francja"),
        listOf("GAB", "Gabon"),
        listOf("GMB", "Gambia"),
        listOf("GHA", "Ghana"),
        listOf("GRC", "Grecja"),
        listOf("GRD", "Grenada"),
        listOf("GEO", "Gruzja"),
        listOf("GUF", "Gujana"),
        listOf("GTM", "Gwatemala"),
        listOf("GIN", "Gwinea"),
        listOf("GNB", "Gwinea Bissau"),
        listOf("GNQ", "Gwinea Równikowa"),
        listOf("HTI", "Haiti"),
        listOf("ESP", "Hiszpania"),
        listOf("NLD", "Holandia"),
        listOf("HND", "Honduras"),
        listOf("IND", "Indie"),
        listOf("IDN", "Indonezja"),
        listOf("IRQ", "Irak"),
        listOf("IRN", "Iran"),
        listOf("IRL", "Irlandia"),
        listOf("ISL", "Islandia"),
        listOf("ISR", "Izrael"),
        listOf("JAM", "Jamajka"),
        listOf("JPN", "Japonia"),
        listOf("YEM", "Jemen"),
        listOf("JOR", "Jordania"),
        listOf("KHM", "Kambodża"),
        listOf("CMR", "Kamerun"),
        listOf("CAN", "Kanada"),
        listOf("QAT", "Katar"),
        listOf("KAZ", "Kazachstan"),
        listOf("KEN", "Kenia"),
        listOf("KGZ", "Kirgistan"),
        listOf("KIR", "Kiribati"),
        listOf("COL", "Kolumbia"),
        listOf("COM", "Komory"),
        listOf("COG", "Kongo"),
        listOf("KOR", "Korea Południowa"),
        listOf("PRK", "Korea Północna"),
        listOf("CRI", "Kostaryka"),
        listOf("CUB", "Kuba"),
        listOf("KWT", "Kuwejt"),
        listOf("LAO", "Laos"),
        listOf("LSO", "Lesotho"),
        listOf("LBN", "Liban"),
        listOf("LBR", "Liberia"),
        listOf("LBY", "Libia"),
        listOf("LIE", "Liechtenstein"),
        listOf("LTU", "Litwa"),
        listOf("LUX", "Luksemburg"),
        listOf("LVA", "Łotwa"),
        listOf("MKD", "Macedonia Północna"),
        listOf("MDG", "Madagaskar"),
        listOf("MWI", "Malawi"),
        listOf("MDV", "Malediwy"),
        listOf("MYS", "Malezja"),
        listOf("MLI", "Mali"),
        listOf("MLT", "Malta"),
        listOf("MAR", "Maroko"),
        listOf("MRT", "Mauretania"),
        listOf("MUS", "Mauritius"),
        listOf("MEX", "Meksyk"),
        listOf("FSM", "Mikronezja"),
        listOf("MMR", "Mjanma"),
        listOf("MDA", "Mołdawia"),
        listOf("MCO", "Monako"),
        listOf("MNG", "Mongolia"),
        listOf("MOZ", "Mozambik"),
        listOf("NAM", "Namibia"),
        listOf("NRU", "Nauru"),
        listOf("NPL", "Nepal"),
        listOf("DEU", "Niemcy"),
        listOf("NER", "Niger"),
        listOf("NGA", "Nigeria"),
        listOf("NIC", "Nikaragua"),
        listOf("NOR", "Norwegia"),
        listOf("NZL", "Nowa Zelandia"),
        listOf("OMN", "Oman"),
        listOf("PAK", "Pakistan"),
        listOf("PLW", "Palau"),
        listOf("PAN", "Panama"),
        listOf("PNG", "Papua-Nowa Gwinea"),
        listOf("PRY", "Paragwaj"),
        listOf("PER", "Peru"),
        listOf("POL", "Polska"),
        listOf("ZAF", "Południowa Afryka"),
        listOf("POR", "Portugalia"),
        listOf("CAF", "Republika Środkowoafrykańska"),
        listOf("CPV", "Republika Zielonego Przylądka"),
        listOf("RUS", "Rosja"),
        listOf("ROU", "Rumunia"),
        listOf("RWA", "Rwanda"),
        listOf("KNA", "Saint Kitts i Nevis"),
        listOf("LCA", "Saint Lucia"),
        listOf("VCT", "Saint Vincent i Grenadyny"),
        listOf("SLV", "Salwador"),
        listOf("WSM", "Samoa"),
        listOf("SMR", "San Marino"),
        listOf("SEN", "Senegal"),
        listOf("SRB", "Serbia"),
        listOf("SYC", "Seszele"),
        listOf("SLE", "Sierra Leone"),
        listOf("SGP", "Singapur"),
        listOf("SVK", "Słowacja"),
        listOf("SVN", "Słowenia"),
        listOf("SOM", "Somalia"),
        listOf("LKA", "Sri Lanka"),
        listOf("USA", "Stany Zjednoczone"),
        listOf("SDN", "Sudan"),
        listOf("SSD", "Sudan Południowy"),
        listOf("SUR", "Surinam"),
        listOf("SYR", "Syria"),
        listOf("CHE", "Szwajcaria"),
        listOf("SWE", "Szwecja"),
        listOf("TJK", "Tadżykistan"),
        listOf("THA", "Tajlandia"),
        listOf("TZA", "Tanzania"),
        listOf("TLS", "Timor Wschodni"),
        listOf("TGO", "Togo"),
        listOf("TON", "Tonga"),
        listOf("TTO", "Trynidad i Tobago"),
        listOf("TUN", "Tunezja"),
        listOf("TUR", "Turcja"),
        listOf("TKM", "Turkmenistan"),
        listOf("TUV", "Tuvalu"),
        listOf("UGA", "Uganda"),
        listOf("UKR", "Ukraina"),
        listOf("URY", "Urugwaj"),
        listOf("UZB", "Uzbekistan"),
        listOf("VUT", "Vanuatu"),
        listOf("VAT", "Watykan"),
        listOf("VEN", "Wenezuela"),
        listOf("HUN", "Węgry"),
        listOf("GBR", "Wielka Brytania"),
        listOf("VNM", "Wietnam"),
        listOf("ITA", "Włochy"),
        listOf("CIV", "Wybrzeże Kości Słoniowej"),
        listOf("MHL", "Wyspy Marshalla"),
        listOf("SLB", "Wyspy Salomona"),
        listOf("STP", "Wyspy Świętego Tomasza i Książęca"),
        listOf("ZMB", "Zambia"),
        listOf("ZWE", "Zimbabwe"),
        listOf("ARE", "Zjednoczone Emiraty Arabskie")
    )

    fun getCountries(): ArrayList<List<String>> {
        return countries
    }

    fun getCountryByCode(code: String): String {
        for(c in countries)
            if(c[0] == code) return c[1]
        return ""
    }
}