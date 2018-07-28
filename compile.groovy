def rootPath = new File(".").getCanonicalPath()

def map = [:]

new File("${rootPath}/src").eachFile { file ->
    def fileName = file.getName()


    if (fileName.startsWith("_")) {
        map.put fileName, file.text
    }
}


new File("${rootPath}/src").eachFile { file ->
    def fileName = file.getName()

    if (!fileName.startsWith("_")) {
        def html = file.text

        map.each { name, text ->
            html = html.replaceAll(name, text)
        }
        new File("${rootPath}/docs/${fileName}") << html

    }

}
