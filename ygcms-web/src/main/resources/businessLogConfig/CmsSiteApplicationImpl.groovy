class CmsSiteApplicationImpl {

	def context
	
	def CmsSiteApplicationImpl_creatCmsSite(){
		"${getPreTemplate()}创建站点成功" 
	}
	
	def CmsSiteApplicationImpl_updateCmsSite(){
		"${getPreTemplate()}更新站点成功" 
	}
	
	def getPreTemplate(){        
	    "${context._user}-"     
	} 
	
}