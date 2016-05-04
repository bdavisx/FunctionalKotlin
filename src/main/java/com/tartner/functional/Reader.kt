/*
The EnvironmentType might be a Repository, for example.
 */
class Reader<EnvironmentType, A>(val run: (EnvironmentType) -> A) {
    fun <B> map(mapFunction : (A) -> B): com.tartner.functional.Reader<EnvironmentType, B> =
        com.tartner.functional.Reader({ r -> mapFunction(run(r)) })

    fun <B> flatMap(flatmapFunction : (A) -> com.tartner.functional.Reader<EnvironmentType, B>)
        : com.tartner.functional.Reader<EnvironmentType, B> =
        com.tartner.functional.Reader({ r -> flatmapFunction(run(r)).run(r) })
}
