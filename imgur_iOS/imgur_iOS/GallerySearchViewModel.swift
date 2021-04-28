//
// Created by Nick Achtien on 4/27/21.
// Copyright (c) 2021 orgName. All rights reserved.
//

import Foundation
import shared

class GallerySearchViewModel: ObservableObject {
    private let repository: ImgurRepository

    init(repository: ImgurRepository) {
        self.repository = repository
    }

    func searchGalleries(query: String) -> Galleries {
        return repository.searchForGallery(query: query)
    }
}
