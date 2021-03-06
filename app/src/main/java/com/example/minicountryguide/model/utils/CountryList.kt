package com.example.minicountryguide.model.utils

object CountryList {
    private val countries = arrayListOf(
        listOf("AFG", "Afghanistan"),
        listOf("ALB", "Albania"),
        listOf("DZA", "Algeria"),
        listOf("AND", "Andorra"),
        listOf("AGO", "Angola"),
        listOf("ATG", "Antigua and Barbuda"),
        listOf("ARG", "Argentina"),
        listOf("ARM", "Armenia"),
        listOf("AUS", "Australia"),
        listOf("AUT", "Austria"),
        listOf("AZE", "Azerbaijan"),
        listOf("BHS", "Bahamas"),
        listOf("BHR", "Bahrain"),
        listOf("BGD", "Bangladesh"),
        listOf("BRB", "Barbados"),
        listOf("BLR", "Belarus"),
        listOf("BEL", "Belgium"),
        listOf("BLZ", "Belize"),
        listOf("BEN", "Benin"),
        listOf("BTN", "Bhutan"),
        listOf("BOL", "Bolivia"),
        listOf("BIH", "Bosnia and Herzegovina"),
        listOf("BWA", "Botswana"),
        listOf("BRA", "Brazil"),
        listOf("BRN", "Brunei"),
        listOf("BGR", "Bulgaria"),
        listOf("BFA", "Burkina Faso"),
        listOf("BDI", "Burundi"),
        listOf("CIV", "Côte d'Ivoire"),
        listOf("CPV", "Cabo Verde"),
        listOf("KHM", "Cambodia"),
        listOf("CMR", "Cameroon"),
        listOf("CAN", "Canada"),
        listOf("CAF", "Central African Republic"),
        listOf("TCD", "Chad"),
        listOf("CHL", "Chile"),
        listOf("CHN", "China"),
        listOf("COL", "Colombia"),
        listOf("COM", "Comoros"),
        listOf("COG", "Congo"),
        listOf("CRI", "Costa Rica"),
        listOf("HRV", "Croatia"),
        listOf("CUB", "Cuba"),
        listOf("CYP", "Cyprus"),
        listOf("CZE", "Czechia"),
        listOf("COD", "Democratic Republic of the Congo"),
        listOf("DNK", "Denmark"),
        listOf("DJI", "Djibouti"),
        listOf("DMA", "Dominica"),
        listOf("DOM", "Dominican Republic"),
        listOf("ECU", "Ecuador"),
        listOf("EGY", "Egypt"),
        listOf("SLV", "El Salvador"),
        listOf("GNQ", "Equatorial Guinea"),
        listOf("ERI", "Eritrea"),
        listOf("EST", "Estonia"),
        listOf("SWZ", "Eswatini"),
        listOf("ETH", "Ethiopia"),
        listOf("FJI", "Fiji"),
        listOf("FIL", "Finland"),
        listOf("FRA", "France"),
        listOf("GAB", "Gabon"),
        listOf("GMB", "Gambia"),
        listOf("GEO", "Georgia"),
        listOf("DEU", "Germany"),
        listOf("GHA", "Ghana"),
        listOf("GRC", "Greece"),
        listOf("GRD", "Grenada"),
        listOf("GTM", "Guatemala"),
        listOf("GIN", "Guinea"),
        listOf("GNB", "Guinea-Bissau"),
        listOf("GUF", "Guyana"),
        listOf("HTI", "Haiti"),
        listOf("VAT", "Holy See"),
        listOf("HND", "Honduras"),
        listOf("HUN", "Hungary"),
        listOf("ISL", "Iceland"),
        listOf("IND", "India"),
        listOf("IDN", "Indonesia"),
        listOf("IRN", "Iran"),
        listOf("IRQ", "Iraq"),
        listOf("IRL", "Ireland"),
        listOf("ISR", "Israel"),
        listOf("ITA", "Italy"),
        listOf("JAM", "Jamaica"),
        listOf("JPN", "Japan"),
        listOf("JOR", "Jordan"),
        listOf("KAZ", "Kazakhstan"),
        listOf("KEN", "Kenya"),
        listOf("KIR", "Kiribati"),
        listOf("KWT", "Kuwait"),
        listOf("KGZ", "Kyrgyzstan"),
        listOf("LAO", "Laos"),
        listOf("LVA", "Latvia"),
        listOf("LBN", "Lebanon"),
        listOf("LSO", "Lesotho"),
        listOf("LBR", "Liberia"),
        listOf("LBY", "Libya"),
        listOf("LIE", "Liechtenstein"),
        listOf("LTU", "Lithuania"),
        listOf("LUX", "Luxembourg"),
        listOf("MDG", "Madagascar"),
        listOf("MWI", "Malawi"),
        listOf("MYS", "Malaysia"),
        listOf("MDV", "Maldives"),
        listOf("MLI", "Mali"),
        listOf("MLT", "Malta"),
        listOf("MHL", "Marshall Islands"),
        listOf("MRT", "Mauritania"),
        listOf("MUS", "Mauritius"),
        listOf("MEX", "Mexico"),
        listOf("FSM", "Micronesia"),
        listOf("MDA", "Moldova"),
        listOf("MCO", "Monaco"),
        listOf("MNG", "Mongolia"),
        listOf("MNE", "Montenegro"),
        listOf("MAR", "Morocco"),
        listOf("MOZ", "Mozambique"),
        listOf("MMR", "Myanmar"),
        listOf("NAM", "Namibia"),
        listOf("NRU", "Nauru"),
        listOf("NPL", "Nepal"),
        listOf("NLD", "Netherlands"),
        listOf("NZL", "New Zealand"),
        listOf("NIC", "Nicaragua"),
        listOf("NER", "Niger"),
        listOf("NGA", "Nigeria"),
        listOf("PRK", "North Korea"),
        listOf("MKD", "North Macedonia"),
        listOf("NOR", "Norway"),
        listOf("OMN", "Oman"),
        listOf("PAK", "Pakistan"),
        listOf("PLW", "Palau"),
        listOf("PAN", "Panama"),
        listOf("PNG", "Papua New Guinea"),
        listOf("PRY", "Paraguay"),
        listOf("PER", "Peru"),
        listOf("PHL", "Philipines"),
        listOf("POL", "Poland"),
        listOf("POR", "Portugal"),
        listOf("QAT", "Qatar"),
        listOf("ROU", "Romania"),
        listOf("RUS", "Russia"),
        listOf("RWA", "Rwanda"),
        listOf("KNA", "Saint Kitts and Nevis"),
        listOf("LCA", "Saint Lucia"),
        listOf("VCT", "Saint Vincent and the Grenadines"),
        listOf("WSM", "Samoa"),
        listOf("SMR", "San Marino"),
        listOf("STP", "Sao Tome and Principe"),
        listOf("SAU", "Saudi Arabia"),
        listOf("SEN", "Senegal"),
        listOf("SRB", "Serbia"),
        listOf("SYC", "Seycheles"),
        listOf("SLE", "Sierra Leone"),
        listOf("SGP", "Singapore"),
        listOf("SVK", "Slovakia"),
        listOf("SVN", "Slovenia"),
        listOf("SLB", "Solomon Islands"),
        listOf("SOM", "Somalia"),
        listOf("ZAF", "South Africa"),
        listOf("KOR", "South Korea"),
        listOf("SSD", "South Sudan"),
        listOf("ESP", "Spain"),
        listOf("LKA", "Sri Lanka"),
        listOf("SDN", "Sudan"),
        listOf("SUR", "Suriname"),
        listOf("SWE", "Sweden"),
        listOf("CHE", "Switzerland"),
        listOf("SYR", "Syria"),
        listOf("TJK", "Tajikistan"),
        listOf("TZA", "Tanzania"),
        listOf("THA", "Thailand"),
        listOf("TLS", "Timor-Leste"),
        listOf("TGO", "Togo"),
        listOf("TON", "Tonga"),
        listOf("TTO", "Trinidad and Tobago"),
        listOf("TUN", "Tunisia"),
        listOf("TUR", "Turkey"),
        listOf("TKM", "Turkmenistan"),
        listOf("TUV", "Tuvalu"),
        listOf("UGA", "Uganda"),
        listOf("UKR", "Ukraine"),
        listOf("ARE", "United Arab Emirates"),
        listOf("GBR", "United Kingdom"),
        listOf("USA", "United States of America"),
        listOf("URY", "Uruguay"),
        listOf("UZB", "Uzbekistan"),
        listOf("VUT", "Vanuatu"),
        listOf("VEN", "Venezuela"),
        listOf("VNM", "Vietnam"),
        listOf("YEM", "Yemen"),
        listOf("ZMB", "Zambia"),
        listOf("ZWE", "Zimbabwe"),
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