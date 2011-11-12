dependencies = {
	layers: [
	    { 
           name: "../anzo/anzo.js", 
           copyrightFile: "../../anzo/copyright.txt",
           dependencies: [ 
           
                "anzo.client.DatasetService",
           
                "dojox.uuid",
                "anzo.rdf.BaseQuadStore",
                "anzo.rdf.GraphResource",
                "anzo.rdf.INamedGraph",
                "anzo.rdf.NamedGraph",
                "anzo.rdf.QuadStore",
                "anzo.rdf.Statement",
                
                "anzo.rdf.parser.NTripleParser",
                "anzo.rdf.parser.TabulatorParser",
                
                "anzo.rdf.vocabulary.DC",
                "anzo.rdf.vocabulary.OWL",
                "anzo.rdf.vocabulary.RDF",
                "anzo.rdf.vocabulary.RDFS",
                "anzo.rdf.vocabulary.XMLSchema"
                
            ] 
        }
		
	],

	prefixes: [
		//[ "anzo",   "../../../anzo"] 
	]
}
