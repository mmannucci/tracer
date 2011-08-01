class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
        "/timeline"(controller:"post", action:"timeline")
		"500"(view:'/error')
	}
}
