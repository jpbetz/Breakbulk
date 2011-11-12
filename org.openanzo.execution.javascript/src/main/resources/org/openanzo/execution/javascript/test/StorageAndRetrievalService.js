

service = {
	
	storeStatements : function(context, request, response) {
		context.getAnzoClient().importStatements(request.getStatements());
		response.addNamedGraph(context.getOperationURI());
		var statusPred = valueFactory.createURI(context.getServiceURI().toString() + "#status");
		var status = valueFactory.createLiteral("Statements Stored");
		var stmt = valueFactory.createStatement(context.getOperationURI(),statusPred,status,context.getOperationURI());
		response.add(stmt);
	},
	
	retrieveStatements : function(context, request, response) {
		var itr = request.getNamedGraphUris().iterator();
		while (itr.hasNext()) {
			var uri = itr.next();
			var graph = null;
			try {
				graph = context.getAnzoClient().getServerGraph(uri);
				var graphStmts = graph.getStatements();
				if (!graphStmts.isEmpty()) {
					response.addNamedGraph(uri);
					response.add(graph.getStatements());
				}
			} finally {
				if (graph) {
					graph.close();
				}
			}
		}
	},
	
	initialize : function(semanticService) {
		
	},
	
	stop : function() {
	
	}
	
};