package org.bryanollivie.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform