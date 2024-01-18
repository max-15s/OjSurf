// https://leetcode.com/problems/design-authentication-manager/

class AuthenticationManager(timeToLive: Int) {
    val keyStore = mutableSetOf<String>()
    val unify = HashMap<String, Int>()
    val timeToLive = timeToLive

    fun generate(tokenId: String, currentTime: Int) {
        keyStore.add(tokenId)
        unify[tokenId] = currentTime + timeToLive
    }

    fun renew(tokenId: String, currentTime: Int) {
        val ttl = unify[tokenId]
        if (ttl != null && ttl > currentTime)
            unify[tokenId] = currentTime + timeToLive
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        val toRemove = mutableSetOf<String>()
        for (k in keyStore)
            if (unify[k]!! <= currentTime) {
                toRemove.add(k)
                unify.remove(k)
            }
        keyStore.removeAll(toRemove)
        return keyStore.size
    }
}

fun main(){
//    val s = AuthenticationManager(13)
//    println(s.renew("ajvy",1))
//    println(s.countUnexpiredTokens(3))
//    println(s.countUnexpiredTokens(4))
//    println(s.generate("fuzxq",5))
//    println(s.generate("izmry",7))
//    println(s.renew("puv",12))
//    println(s.generate("ybiqb",13))
//    println(s.generate("gm",14))
//    println(s.countUnexpiredTokens(15))
//    println(s.countUnexpiredTokens(18))
//    println(s.countUnexpiredTokens(19))
//    println(s.renew("ybiqb",21))
//    println(s.countUnexpiredTokens(23))
//    println(s.countUnexpiredTokens(25))
//    println(s.countUnexpiredTokens(26))
//    println(s.generate("aqdm",28))
//    println(s.countUnexpiredTokens(29))
//    println(s.renew("puv",30))
    val s = AuthenticationManager(5)
    println(s.renew("aaa",1))
    println(s.generate("aaa",2))
    println(s.countUnexpiredTokens(6))
    println(s.generate("bbb",7))
    println(s.renew("aaa",8))
    println(s.renew("bbb",10))
    println(s.countUnexpiredTokens(15))

}