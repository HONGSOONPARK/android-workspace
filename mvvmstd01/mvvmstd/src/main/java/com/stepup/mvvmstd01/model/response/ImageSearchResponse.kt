package com.stepup.mvvmstd01.model.response

/**
 * 클래스 설명
 *
 * @author 최초작성자:
 * @date 최초작성일: 2020-08-11 오후 6:06
 *
 */
data class ImageSearchResponse (
    var documents:ArrayList<Document>,
    var meta:Meta
) {
    data class Document(
        var collection:String,
        var thumbnail_url:String,
        var image_url:String,
        var width:Int,
        var height:Int,
        var display_sitename:String,
        var doc_url:String,
        var datetime:String
    )
    data class Meta(
        var total_count:Int,
        var pageable_count:Int,
        var is_end:Boolean
    )
}