//
//  ViewModel.swift
//  imgur_iOS
//
//  Created by Nick Achtien on 4/27/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import common
import Combine

class GallerySearchViewModel: ObservableObject {
    private let repository: ImgurRepository
    
    @Published var galleries : Galleries?
    @Published var query: String = ""
    private var cancellable = Set<AnyCancellable>()
    
    init(repository: ImgurRepository) {
        self.repository = repository
        
        $query
           .debounce(for: 0.5, scheduler: RunLoop.main)
            .receive(on: RunLoop.main)
            .sink { query in
                repository.searchForGallery(query: query) { result, error in
                    if let e = error {
                        print("ERROR: \(e)")
                    } else {
                        self.galleries = result
                    }
                }
            }
            .store(in: &cancellable)
    }
}
