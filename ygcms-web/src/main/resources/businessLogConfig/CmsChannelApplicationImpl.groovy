
class CmsChannelApplicationImpl {

	def context
	
	def CmsChannelApplicationImpl_creatCmsChannel(){
		"创建栏目成功" 
	}
	
	def CmsChannelApplicationImpl_updateCmsChannel(){
		"更新栏目成功" 
	}
	
	def getPreTemplate(){         
	    "${context._user}-"     
	} 
}